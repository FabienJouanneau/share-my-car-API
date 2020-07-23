package com.fabienjouanneau.sharemycar.website.webServices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.postUser(user);
    }
    @PutMapping("{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        if(user.getUserId() == id){
            return userService.putUser(user, id);
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
