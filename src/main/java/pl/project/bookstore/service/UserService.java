package pl.project.bookstore.service;

import pl.project.bookstore.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    List<User> getAll();

    User addUser(User user);
    User updateUser(User user, Long id);
    void deleteUser(Long id);

}
