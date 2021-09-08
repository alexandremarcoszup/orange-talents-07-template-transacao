package com.orangetalents.transacoes.controller;

import com.orangetalents.transacoes.controller.request.CartaoRequest;
import com.orangetalents.transacoes.controller.response.CartaoResponse;
import com.orangetalents.transacoes.domain.modelo.Cartao;
import com.orangetalents.transacoes.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoResponse> createCard(@RequestBody @Valid CartaoRequest cartaoRequest,
                                                     UriComponentsBuilder uriComponentsBuilder) {

        Cartao cartao = cartaoService.obtemCartao(cartaoRequest);

        URI uri = uriComponentsBuilder.buildAndExpand(cartao.getId()).toUri();

        return ResponseEntity.created(uri).body(cartao.domainToResponse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable("id") String idCartao){



        cartaoService.deleteCartao(idCartao);
        return ResponseEntity.noContent().build();
    }
}
