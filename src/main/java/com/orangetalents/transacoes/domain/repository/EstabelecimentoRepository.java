package com.orangetalents.transacoes.domain.repository;

import com.orangetalents.transacoes.domain.modelo.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
