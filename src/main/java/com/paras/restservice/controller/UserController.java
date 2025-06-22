package com.paras.restservice.controller;

import com.paras.restservice.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author parachau
 **/

@RestController
@RequestMapping("api/users")
public class UserController {

    Deque<User> users = new ArrayDeque<>();

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return users.stream()
                .filter(u->u.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        boolean isUserExists = users.stream().anyMatch(u->u.getId()==user.getId());
        if(!isUserExists) {
            users.offerLast(user);
            return user.toString();
        }
        else{
            return "User already exists";
        }
    }

    @DeleteMapping()
    public String deleteUser(@RequestBody User user) {
        User userToBeDeleted = users.stream()
                .filter(u-> u.getId() == user.getId())
                .findFirst()
                .orElse(null);

        if (userToBeDeleted != null) {
            users.remove(userToBeDeleted);
            return "User deleted";
        }
        else{
            return "User not found";
        }

//        users.stream()
//                .filter(u -> u.getId() == user.getId())
//                .findFirst().ifPresent(u -> users.remove(u));

    }

}
