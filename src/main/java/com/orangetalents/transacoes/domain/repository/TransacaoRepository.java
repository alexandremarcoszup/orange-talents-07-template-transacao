package com.orangetalents.transacoes.domain.repository;

import com.orangetalents.transacoes.domain.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, String> {

    Page<Transacao> findAllByCartaoId(String idCartao, Pageable pageable);
}
