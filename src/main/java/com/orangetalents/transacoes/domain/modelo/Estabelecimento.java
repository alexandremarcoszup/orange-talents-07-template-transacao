package com.orangetalents.transacoes.domain.modelo;

import com.orangetalents.transacoes.controller.response.EstabelecimentoResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cidade;

    private String endereco;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST)
    private List<Transacao> transacao = new ArrayList<>();

    @Deprecated
    public Estabelecimento(){}

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento(String nome, String cidade, String endereco, Transacao transacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.transacao.add(transacao);
    }

    public EstabelecimentoResponse domainToResponse(){
        return new EstabelecimentoResponse(this.id, this.nome, this.cidade, this.endereco);
    }
}