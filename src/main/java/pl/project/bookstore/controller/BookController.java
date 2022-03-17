package pl.project.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.bookstore.model.Book;
import pl.project.bookstore.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public Book getBook (){
        return new Book(0, "Ania z Zielonego Wzgórza", "Lucy Maud Montgomery");
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable ("id") long id, @RequestBody Book book){
        return new ResponseEntity<Book>(bookService.updateBookById(book, id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable ("id") long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<String>("Książka została usunięta", HttpStatus.OK);
    }
}
