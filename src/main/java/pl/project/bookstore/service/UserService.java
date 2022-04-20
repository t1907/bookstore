package pl.project.bookstore.service;

import pl.project.bookstore.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);
    List<User> getAll();

    User addUser(User user);
    User updateUser(User user, UUID id);
    void deleteUser(UUID id);

    User loginUser(String login);

}
