package com.project.taskmanagement.converter;

import org.springframework.stereotype.Component;

import com.project.taskmanagement.dto.UserDTO;
import com.project.taskmanagement.entity.UserEntity;

@Component
public class UserConverter {
    
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUsername(userDTO.getUsername());
        return userEntity;
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUsername(userEntity.getUsername());
        return userDTO;
    }
}
