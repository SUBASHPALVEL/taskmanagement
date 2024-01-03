package com.project.taskmanagement.controller;

import com.project.taskmanagement.dto.UserDTO;
import com.project.taskmanagement.dto.TaskDTO;
import com.project.taskmanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.createUser(userDTO);
        // return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
        return "home";
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(userDTO);
        if (updatedUserDTO != null) {
            return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDTO>> getAssignedTasksByUserId(@PathVariable Long userId) {
        List<TaskDTO> assignedTasks = userService.getAssignedTasksByUserId(userId);
        if (assignedTasks != null) {
            return new ResponseEntity<>(assignedTasks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/login",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public ResponseEntity<UserDTO> login(@Valid @ModelAttribute("user") UserDTO userDTO) {
        userDTO = userService.login(userDTO.getUsermail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
