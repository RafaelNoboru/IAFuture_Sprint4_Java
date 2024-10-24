CREATE TABLE reviews
(
    id      BIGSERIAL PRIMARY KEY,
    comment TEXT,
    rating  INT CHECK (rating >= 1 AND rating <= 5),
    book_id BIGINT,
    user_id BIGINT,
    CONSTRAINT fk_book
        FOREIGN KEY (book_id)
            REFERENCES books (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);