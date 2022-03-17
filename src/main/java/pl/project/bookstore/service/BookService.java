package pl.project.bookstore.service;

import pl.project.bookstore.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();

    Book updateBookById(Book book, Long id);

    void deleteBookById(Long id);
}
