package com.project.taskmanagement.dto;

import com.project.taskmanagement.entity.TaskEntity;
import com.project.taskmanagement.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserTaskDTO {
    private Long userTaskId;
    private UserEntity user;
    private TaskEntity task;
    private String role; 
}
