package br.com.fiap.iafuture.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Token login(@RequestParam String username, @RequestParam String senha) {
        Credentials credentials = new Credentials(username, senha);
        return authService.login(credentials);
    }
}
