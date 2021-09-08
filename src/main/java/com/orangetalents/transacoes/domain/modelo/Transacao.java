package com.orangetalents.transacoes.domain.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
