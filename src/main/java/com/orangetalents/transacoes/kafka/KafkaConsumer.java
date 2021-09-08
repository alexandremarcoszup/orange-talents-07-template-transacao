package com.orangetalents.transacoes.kafka;

import com.orangetalents.transacoes.domain.repository.TransacaoRepository;
import com.orangetalents.transacoes.kafka.menssage.TransacaoMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final TransacaoRepository transacaoRepository;

    public KafkaConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", containerFactory = "kafkaListenerContainerFactory")
    public void consome(@Payload TransacaoMessage transacaoMessage) {
        transacaoRepository.save(transacaoMessage.messageToDomain());
    }
}
