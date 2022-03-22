package pl.project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.bookstore.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
