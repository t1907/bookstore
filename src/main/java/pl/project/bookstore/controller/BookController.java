package pl.project.bookstore.controller;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.bookstore.model.Book;
import pl.project.bookstore.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/book/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
        return new ResponseEntity<Book>(bookService.updateBookById(book, id), HttpStatus.OK);
    }

    @DeleteMapping("book/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<String>("Książka została usunięta", HttpStatus.OK);
    }
}
