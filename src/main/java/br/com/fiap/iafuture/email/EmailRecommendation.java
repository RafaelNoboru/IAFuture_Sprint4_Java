package br.com.fiap.iafuture.email;

import lombok.Data;

@Data
public class EmailRecommendation {

    private String email;
    private String recommendation;

    public EmailRecommendation(String email, String recommendation) {
        this.email = email;
        this.recommendation = recommendation;
    }
}
