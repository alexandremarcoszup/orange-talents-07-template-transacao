package com.orangetalents.transacoes.service;

import com.orangetalents.transacoes.controller.request.CartaoRequest;
import com.orangetalents.transacoes.domain.modelo.Cartao;

public interface CartaoService {

    Cartao obtemCartao(CartaoRequest cartaoRequest);

    void deleteCartao(String idCartao);
}
