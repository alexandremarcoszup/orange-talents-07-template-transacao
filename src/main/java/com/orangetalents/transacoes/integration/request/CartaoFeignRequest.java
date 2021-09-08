package com.orangetalents.transacoes.integration.request;

public class CartaoFeignRequest {

    private String id;

    private String email;

    public CartaoFeignRequest(){}

    public CartaoFeignRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


}
