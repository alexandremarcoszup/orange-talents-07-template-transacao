package com.orangetalents.transacoes.service;

import com.orangetalents.transacoes.controller.request.CartaoRequest;
import com.orangetalents.transacoes.controller.response.TransacaoResponse;
import com.orangetalents.transacoes.domain.modelo.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartaoService {

    Cartao obtemCartao(CartaoRequest cartaoRequest);

    void deleteCartao(String idCartao);

    Page<TransacaoResponse> getTransactions(String idCartao, Pageable pageable);
}
