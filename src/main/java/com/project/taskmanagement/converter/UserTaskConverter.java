package com.project.taskmanagement.converter;

import org.springframework.stereotype.Component;

import com.project.taskmanagement.dto.UserTaskDTO;
import com.project.taskmanagement.entity.UserTaskEntity;
@Component
public class UserTaskConverter {
    
    public UserTaskDTO convertEntitytoDTO(UserTaskEntity userTaskEntity){
        UserTaskDTO userTaskDTO = new UserTaskDTO();
        userTaskDTO.setUserTaskId(userTaskEntity.getUserTaskId());
        userTaskDTO.setUser(userTaskEntity.getUser());
        userTaskDTO.setTask(userTaskEntity.getTask());
        userTaskDTO.setRole(userTaskEntity.getRole());
        return userTaskDTO;
    }

    public UserTaskEntity convertDTOtoEntity(UserTaskDTO userTaskDTO ){
        UserTaskEntity userTaskEntity = new UserTaskEntity();
        userTaskEntity.setUserTaskId(userTaskDTO.getUserTaskId());
        userTaskEntity.setUser(userTaskDTO.getUser());
        userTaskEntity.setTask(userTaskDTO.getTask());
        userTaskEntity.setRole(userTaskDTO.getRole());
        return userTaskEntity;
    }
}
