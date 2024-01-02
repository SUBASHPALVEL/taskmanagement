package com.project.taskmanagement.service.impl;

import com.project.taskmanagement.dto.UserDTO;
import com.project.taskmanagement.service.UserService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<UserDTO> users = new ArrayList<>();

    @Override
    public List<UserDTO> getAllUsers() {
        return users;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return findUserById(userId);
    }

    @Override
    public UserDTO createUser(UserDTO newUser) {
        users.add(newUser);
        return newUser;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUser) {
        UserDTO existingUser = findUserById(userId);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            return existingUser;
        } else {
            return null; // Or throw an exception indicating not found
        }
    }

    @Override
    public void deleteUser(Long userId) {
        UserDTO user = findUserById(userId);
        if (user != null) {
            users.remove(user);
        }
        // Note: If user is not found, you may want to throw an exception or handle it accordingly.
    }

    private UserDTO findUserById(Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
