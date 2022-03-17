package pl.project.bookstore.exception;

public class BookNotFoundEXception extends RuntimeException {
    public BookNotFoundEXception(String s) {
        super(s);
    }
}
