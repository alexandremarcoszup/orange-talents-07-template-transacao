package com.orangetalents.transacoes.controller.request;

import com.orangetalents.transacoes.integration.request.CartaoFeignRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class CartaoRequest {

    @NotBlank
    @Email
    private String email;

    public CartaoRequest(String email) {
        this.email = email;
    }

    public CartaoRequest(){}

    public CartaoFeignRequest requestToFeignRequest(){
        return new CartaoFeignRequest(UUID.randomUUID().toString(), email);
    }

    public String getEmail() {
        return email;
    }
}
