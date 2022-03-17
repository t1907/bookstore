package pl.project.bookstore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.bookstore.model.Book;
import pl.project.bookstore.repository.BookRepository;
import pl.project.bookstore.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBookById(Book book, long id) {
        Book bookFromDB = bookRepository.findById(id).orElseThrow( () -> new RuntimeException("Not found"));
        bookFromDB.setBookId(book.getBookId());
        bookFromDB.setTitle(book.getTitle());
        bookFromDB.setAuthor(book.getAuthor());
        bookRepository.save(bookFromDB);
        return bookFromDB;
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.findById(id).orElseThrow( () -> new RuntimeException("Not found"));
        bookRepository.deleteById(id);
    }
}
