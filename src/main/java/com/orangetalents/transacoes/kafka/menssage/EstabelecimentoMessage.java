package com.orangetalents.transacoes.kafka.menssage;

import com.orangetalents.transacoes.domain.modelo.Estabelecimento;

public class EstabelecimentoMessage {

    private String nome;

    private String cidade;

    private String endereco;

    public EstabelecimentoMessage(){}

    public EstabelecimentoMessage(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento messageToDomain(){
        return new Estabelecimento(nome, cidade, endereco);
    }
}
