package pl.project.bookstore.controller;

import org.springframework.web.bind.annotation.*;
import pl.project.bookstore.model.User;
import pl.project.bookstore.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/user/get/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping(value = "/user/update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

}
