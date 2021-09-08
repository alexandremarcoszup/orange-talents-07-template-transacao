package com.orangetalents.transacoes.controller.response;

public class EstabelecimentoResponse {

    private Long id;

    private String nome;

    private String cidade;

    private String endereco;

    public EstabelecimentoResponse(Long id, String nome, String cidade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
