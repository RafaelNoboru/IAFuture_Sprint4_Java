package br.com.fiap.iafuture.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRecommendationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRecommendation(String book) {
        rabbitTemplate.convertAndSend("bookQueue", book);
    }
}
