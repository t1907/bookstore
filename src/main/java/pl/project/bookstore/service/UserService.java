package pl.project.bookstore.service;

import pl.project.bookstore.model.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);
    List<User> getAll();

    User addUser(User user);
    User updateUser(User user, long id);
    void deleteUser(long id);

}
