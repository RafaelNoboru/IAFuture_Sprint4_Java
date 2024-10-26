package br.com.fiap.iafuture.email;

import br.com.fiap.iafuture.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailRecommendationConsumer {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailRecommendationConsumer(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void processEmailRecommendation(EmailRecommendation emailRecommendation) {
        String email = emailRecommendation.getEmail();
        String recommendation = emailRecommendation.getRecommendation();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Recomendações de Livros para Você!");
        message.setText("Olá!\n\nAqui está sua recomendação de livro:\n\n" + recommendation +
                "\n\nEsperamos que você goste da leitura!\n\nAtenciosamente,\nEquipe IA Future");

        try {
            mailSender.send(message);
            System.out.println("E-mail de recomendação enviado com sucesso para: " + email);
        } catch (Exception e) {
            System.err.println("Erro ao enviar e-mail para " + email + ": " + e.getMessage());
        }
    }
}
