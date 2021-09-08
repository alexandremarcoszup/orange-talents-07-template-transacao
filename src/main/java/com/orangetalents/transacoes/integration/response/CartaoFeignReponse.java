package com.orangetalents.transacoes.integration.response;

import com.orangetalents.transacoes.domain.modelo.Cartao;

public class CartaoFeignReponse {

    private String id;

    private String email;

    public CartaoFeignReponse(){}

    public CartaoFeignReponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao feignRequestToDomain(){
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
