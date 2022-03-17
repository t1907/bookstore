package pl.project.bookstore.service;

import pl.project.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(Book book);
    Book getBookById(long id);
    List<Book> getAllBooks();

    Book updateBookById(Book book, long id);

    void deleteBookById(long id);
}
