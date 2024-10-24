package br.com.fiap.iafuture;

import br.com.fiap.iafuture.book.Book;
import br.com.fiap.iafuture.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "home";
    }
}
