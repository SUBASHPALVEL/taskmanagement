package com.project.taskmanagement.service;

import com.project.taskmanagement.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO createUser(UserDTO newUser);

    UserDTO updateUser(Long userId, UserDTO updatedUser);

    void deleteUser(Long userId);
}
