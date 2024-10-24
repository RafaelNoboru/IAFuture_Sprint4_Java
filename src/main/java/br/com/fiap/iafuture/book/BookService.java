package br.com.fiap.iafuture.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BookService {

    private final String openAiApiKey = "YOUR_OPENAI_API_KEY";
    private final String openAiApiUrl = "https://api.openai.com/v1/engines/davinci/completions";

    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String recommendBooks(BookAttributes attributes) {

        String prompt = String.format("Recomende livros com os seguintes atributos:\n"
                        + "Gênero: %s\n"
                        + "Autor: %s\n"
                        + "Idioma: %s\n"
                        + "Ano de publicação: %s\n",
                attributes.getGenre(),
                attributes.getAuthor(),
                attributes.getLanguage(),
                attributes.getPublicationYear());

        String requestBody = "{"
                + "\"prompt\": \"" + prompt + "\","
                + "\"max_tokens\": 150,"
                + "\"n\": 1,"
                + "\"stop\": null"
                + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openAiApiKey);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(openAiApiUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}
