package pl.project.bookstore.service.impl;

import org.springframework.stereotype.Service;
import pl.project.bookstore.exception.UserNotFoundException;
import pl.project.bookstore.model.User;
import pl.project.bookstore.repository.UserRepository;
import pl.project.bookstore.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User userFromDB = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        userFromDB.setId(user.getId());
        userFromDB.setLogin(user.getLogin());
        userFromDB.setPassword(user.getPassword());
        return userRepository.save(userFromDB);
    }

    @Override
    public void deleteUser(Long id) {
        User userFromDB = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        userRepository.delete(userFromDB);
    }

    @Override
    public User loginUser(String login) {
        User userToLogin = userRepository.findByLogin(login);
        return new User(userToLogin.getId(), userToLogin.getLogin(), userToLogin.getPassword());
    }
}
