package br.com.fiap.iafuture.email;

import br.com.fiap.iafuture.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailRecommendationProducer {

    private final RabbitTemplate rabbitTemplate;

    public EmailRecommendationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEmailRecommendation(String email, String recommendation) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, new EmailRecommendation(email, recommendation));
    }
}

