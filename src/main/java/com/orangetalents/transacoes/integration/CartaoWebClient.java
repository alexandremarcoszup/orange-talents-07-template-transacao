package com.orangetalents.transacoes.integration;

import com.orangetalents.transacoes.integration.request.CartaoFeignRequest;
import com.orangetalents.transacoes.integration.response.CartaoFeignReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cartoes", url = "${api.cartoes.url}")
public interface CartaoWebClient {

    @PostMapping("/cartoes")
    ResponseEntity<CartaoFeignReponse> salvarCartao(@RequestBody CartaoFeignRequest cartaoFeignRequest);

    @DeleteMapping("/cartoes/{id}")
    ResponseEntity deletaCartao(@PathVariable("id") String id);
}
