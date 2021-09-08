package com.orangetalents.transacoes.kafka.menssage;

import com.orangetalents.transacoes.domain.modelo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoMessage estabelecimento;

    private CartaoMessage cartao;

    private LocalDateTime efetivadaEm;

    public TransacaoMessage(){}

    public TransacaoMessage(String id, BigDecimal valor, EstabelecimentoMessage estabelecimento, CartaoMessage cartao,
                            LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(EstabelecimentoMessage estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(CartaoMessage cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao messageToDomain() {
        return new Transacao(id, valor, estabelecimento.messageToDomain(), cartao.messageToDomain(), efetivadaEm);
    }
}
