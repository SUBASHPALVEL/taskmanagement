package com.project.taskmanagement.controller;

import com.project.taskmanagement.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<UserDTO> users = new ArrayList<>();

    // http://localhost:8080/api/users/allUsers
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // http://localhost:8080/api/users/getUser/{userId}
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO user = findUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8080/api/users/createUser
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUser) {
        users.add(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/users/updateUser/{userId}
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO updatedUser) {
        UserDTO existingUser = findUserById(userId);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // http://localhost:8080/api/users/deleteUser/{userId}
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        UserDTO user = findUserById(userId);
        if (user != null) {
            users.remove(user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private UserDTO findUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
