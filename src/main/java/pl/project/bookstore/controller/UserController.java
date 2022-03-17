package pl.project.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
