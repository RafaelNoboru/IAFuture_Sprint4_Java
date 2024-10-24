package br.com.fiap.iafuture.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class BookService {

    private final String openAiApiKey = "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";
    private final String openAiApiUrl = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String recommendBooks(BookAttributes attributes) {

        String messageContent = String.format("Recomende livros com os seguintes atributos:\n"
                        + "Gênero: %s\n"
                        + "Autor: %s\n"
                        + "Idioma: %s\n"
                        + "Ano de publicação: %s\n",
                escapeJson(attributes.getGenre()),
                escapeJson(attributes.getAuthor()),
                escapeJson(attributes.getLanguage()),
                escapeJson(attributes.getPublicationYear()));

        String jsonPayload = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": [{"
                + "\"role\": \"user\","
                + "\"content\": \"" + messageContent + "\""
                + "}],"
                + "\"max_tokens\": 150"
                + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openAiApiKey);

        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(openAiApiUrl, HttpMethod.POST, entity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {

            return "Erro ao obter recomendações: " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "Erro ao chamar a API: " + e.getMessage();
        }
    }

    private String escapeJson(String value) {
        if (value == null) return "";
        return value.replace("\"", "\\\"");
    }

}
