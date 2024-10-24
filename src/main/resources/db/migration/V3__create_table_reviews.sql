CREATE TABLE reviews
(
    id      BIGSERIAL PRIMARY KEY,
    comment TEXT,
    rating  INT CHECK (rating >= 1 AND rating <= 5),
    book_id BIGINT,
    CONSTRAINT fk_book
        FOREIGN KEY (book_id)
            REFERENCES books (id)
            ON DELETE CASCADE
);

INSERT INTO reviews (rating, comment, book_id)
VALUES (5, 'Excellent book! A must-read.', 1);

INSERT INTO reviews (rating, comment, book_id)
VALUES (4, 'Great book, very informative.', 2);

INSERT INTO reviews (rating, comment, book_id)
VALUES (3, 'Good, but could be better in some parts.', 1);

INSERT INTO reviews (rating, comment, book_id)
VALUES (5, 'Loved it! Couldn''t put it down.', 3);