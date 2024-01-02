// UserServiceImpl.java
package com.project.taskmanagement.service.impl;

import com.project.taskmanagement.converter.TaskConverter;
import com.project.taskmanagement.converter.UserConverter;
import com.project.taskmanagement.dto.UserDTO;
import com.project.taskmanagement.dto.TaskDTO;
import com.project.taskmanagement.entity.UserEntity;
import com.project.taskmanagement.repository.UserRepository;
import com.project.taskmanagement.repository.TaskRepository;
import com.project.taskmanagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return (userEntity != null) ? UserConverter.convertToDTO(userEntity) : null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(UserConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = UserConverter.convertToEntity(userDTO);
        userRepository.save(userEntity);
        return UserConverter.convertToDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity existingUserEntity = userRepository.findById(userDTO.getUserId()).orElse(null);
        if (existingUserEntity != null) {
            UserEntity updatedUserEntity = UserConverter.convertToEntity(userDTO);
            userRepository.save(updatedUserEntity);
            return UserConverter.convertToDTO(updatedUserEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<TaskDTO> getAssignedTasksByUserId(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return (userEntity != null)
                ? userEntity.getAssignedTasks().stream().map(TaskConverter::convertToDTO).collect(Collectors.toList())
                : null;
    }
}
