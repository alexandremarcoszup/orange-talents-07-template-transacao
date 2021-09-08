package com.orangetalents.transacoes.kafka.menssage;

import com.orangetalents.transacoes.domain.modelo.Cartao;

public class CartaoMessage {

    private String id;

    private String email;

    public CartaoMessage(){}

    public CartaoMessage(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao messageToDomain(){
        return new Cartao(id, email);
    }
}
