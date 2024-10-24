package br.com.fiap.iafuture.rabbitMQ;

import org.springframework.stereotype.Component;

@Component
public class BookRecommendationConsumer {

    public void receiveRecommendation(String book) {
        System.out.println("Recomendação recebida: " + book);
    }
}
