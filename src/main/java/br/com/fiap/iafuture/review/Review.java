package br.com.fiap.iafuture.review;

import br.com.fiap.iafuture.book.Book;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}

