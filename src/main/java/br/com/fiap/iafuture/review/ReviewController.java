package br.com.fiap.iafuture.review;

import br.com.fiap.iafuture.book.Book;
import br.com.fiap.iafuture.book.BookRepository;
import br.com.fiap.iafuture.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/new")
    public String showNewReviewForm(Model model) {
        model.addAttribute("review", new Review());
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "reviews/new";
    }

    @GetMapping
    public String showReviews(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews/list";
    }

    @PostMapping("/new")
    public String saveReview(Review review, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: " + bookId));

        review.setBook(book);
        reviewRepository.save(review);
        return "redirect:/reviews";
    }
}


