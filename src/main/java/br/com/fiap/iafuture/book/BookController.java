package br.com.fiap.iafuture.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/recommend")
    public String showRecommendationForm(Model model) {
        model.addAttribute("bookAttributes", new BookAttributes());
        return "recommendation-form";
    }

    @PostMapping("/recommend")
    public String getRecommendations(@ModelAttribute BookAttributes bookAttributes, Model model) {
        String recommendations = bookService.recommendBooks(bookAttributes);
        model.addAttribute("recommendations", recommendations);
        return "recommendation-result";
    }
}
