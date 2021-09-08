package com.orangetalents.transacoes.domain.repository;

import com.orangetalents.transacoes.domain.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
