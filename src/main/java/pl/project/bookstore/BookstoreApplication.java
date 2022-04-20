package pl.project.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.project.bookstore.model.Book;
import pl.project.bookstore.model.User;
import pl.project.bookstore.repository.BookRepository;
import pl.project.bookstore.repository.UserRepository;

import java.util.UUID;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(BookstoreApplication.class, args);

		BookRepository bookRepository =
				configurableApplicationContext.getBean(BookRepository.class);

		Book book1 = new Book(0L, "Harry", "JK");
		Book book2 = new Book(0L, "Harry", "JK");
		Book book3 = new Book(0L, "Harry", "JK");
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		UserRepository userRepository =
				configurableApplicationContext.getBean(UserRepository.class);

		User user1 = new User(UUID.randomUUID(), "admin", "admin");
		User user2 = new User(UUID.randomUUID(), "user", "user");
		userRepository.save(user1);
		userRepository.save(user2);

	}

}
