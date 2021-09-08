package com.orangetalents.transacoes.service.impl;

import com.orangetalents.transacoes.controller.request.CartaoRequest;
import com.orangetalents.transacoes.domain.modelo.Cartao;
import com.orangetalents.transacoes.domain.repository.CartaoRepository;
import com.orangetalents.transacoes.integration.CartaoWebClient;
import com.orangetalents.transacoes.service.CartaoService;
import config.handler.EntityException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartaoServiceImpl implements CartaoService {

    private final CartaoRepository cartaoRepository;

    private final CartaoWebClient cartaoWebClient;

    public final Logger log = LoggerFactory.getLogger(CartaoServiceImpl.class);


    public CartaoServiceImpl(CartaoRepository cartaoRepository, CartaoWebClient cartaoWebClient) {
        this.cartaoRepository = cartaoRepository;
        this.cartaoWebClient = cartaoWebClient;
    }

    @Override
    public Cartao obtemCartao(CartaoRequest cartaoRequest) {

        try {
            var cartaoResponse = cartaoWebClient.salvarCartao(cartaoRequest.requestToFeignRequest());

            if (cartaoResponse.getBody() != null) {
                Cartao cartao = cartaoResponse.getBody().feignRequestToDomain();
                cartaoRepository.save(cartao);

                return cartao;
            } else
                throw new EntityException(cartaoRequest.getEmail(), "Erro com ao criar o cartao com o email.");

        } catch (FeignException e) {
            log.error("Erro com o cliente Feign.");
            throw new EntityException(cartaoRequest.getEmail(), "Erro com ao criar o cartao com o email pelo webclient.");
        }
    }

    @Override
    public void deleteCartao(String idCartao) {
        try {
            var response = cartaoWebClient.deletaCartao(idCartao);
            if (response.getStatusCodeValue() == HttpStatus.NO_CONTENT.value()) {
                cartaoRepository.deleteById(idCartao);
            } else
                throw new EntityException(idCartao, "Erro com ao deletar o cartao com o email.");
        } catch (FeignException e) {
            log.error("Erro com o cliente Feign.");
            throw new EntityException(idCartao, "Erro com ao criar o cartao com o email pelo webclient.");
        }
    }
}
