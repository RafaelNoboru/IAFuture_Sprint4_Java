CREATE TABLE books
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    author      VARCHAR(255) NOT NULL,
    genre       VARCHAR(100),
    description TEXT,
    year        INT
);

INSERT INTO books (title, author, genre, description, year)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction',
        'A novel set in the Jazz Age about the elusive Jay Gatsby.', 1925),
       ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'A story about racial injustice in the American South.',
        1960),
       ('1984', 'George Orwell', 'Dystopian', 'A novel about a totalitarian regime that employs surveillance.', 1949),
       ('Pride and Prejudice', 'Jane Austen', 'Romance', 'A classic novel of manners, love, and societal expectations.',
        1813),
       ('Moby Dick', 'Herman Melville', 'Adventure', 'A whaling captain obsessed with a great white whale.', 1851),
       ('War and Peace', 'Leo Tolstoy', 'Historical Fiction', 'A novel set during the Napoleonic Wars in Russia.',
        1869),
       ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 'A story about the rebellious teenager Holden Caulfield.',
        1951),
       ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 'A fantasy adventure about a hobbit named Bilbo Baggins.', 1937),
       ('Brave New World', 'Aldous Huxley', 'Dystopian',
        'A dystopian novel about a futuristic world controlled by technology.', 1932),
       ('Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 'A novel about a society where books are banned and burned.',
        1953),
       ('The Odyssey', 'Homer', 'Epic', 'An ancient Greek epic about Odysseus’ journey home after the Trojan War.',
        -700),
       ('Crime and Punishment', 'Fyodor Dostoevsky', 'Philosophical Fiction',
        'A novel about moral dilemmas and redemption.', 1866),
       ('Don Quixote', 'Miguel de Cervantes', 'Adventure', 'A classic novel about a man who becomes a knight-errant.',
        1605),
       ('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 'An epic fantasy adventure to destroy the One Ring.',
        1954),
       ('The Divine Comedy', 'Dante Alighieri', 'Epic Poetry', 'A journey through Hell, Purgatory, and Heaven.', 1320),
       ('Jane Eyre', 'Charlotte Brontë', 'Romance', 'A novel about the struggles and growth of an orphaned girl.',
        1847),
       ('Frankenstein', 'Mary Shelley', 'Horror', 'A story about a scientist who creates a sentient monster.', 1818),
       ('The Iliad', 'Homer', 'Epic', 'An ancient Greek epic about the Trojan War.', -750),
       ('The Picture of Dorian Gray', 'Oscar Wilde', 'Gothic Fiction',
        'A novel about a man whose portrait ages instead of him.', 1890),
       ('Wuthering Heights', 'Emily Brontë', 'Gothic Fiction',
        'A novel about the passionate love between Heathcliff and Catherine.', 1847);

