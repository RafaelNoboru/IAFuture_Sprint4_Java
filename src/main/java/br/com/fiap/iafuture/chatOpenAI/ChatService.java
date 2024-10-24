package br.com.fiap.iafuture.chatOpenAI;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class ChatService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "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";

    public String getCompletion(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        Map<String, String> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("prompt", prompt);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.openai.com/v1/completions",
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody();
    }
}
