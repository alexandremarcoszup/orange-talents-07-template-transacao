package com.orangetalents.transacoes.domain.repository;

import com.orangetalents.transacoes.domain.modelo.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
