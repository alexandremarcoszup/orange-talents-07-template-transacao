package com.orangetalents.transacoes.domain.modelo;

import com.orangetalents.transacoes.controller.response.CartaoResponse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {

    @Id
    private String id;

    private String email;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Transacao> transacoes = new ArrayList<>();

    @Deprecated
    public Cartao(){}

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao(String id, String email, Transacao transacoes) {
        this.id = id;
        this.email = email;
        this.transacoes.add(transacoes);
    }

    public String getId() {
        return id;
    }

    public CartaoResponse domainToResponse() {
        return new CartaoResponse(id, email);
    }
}