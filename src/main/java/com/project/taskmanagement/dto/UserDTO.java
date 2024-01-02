package com.project.taskmanagement.dto;

import java.util.List;

import com.project.taskmanagement.entity.TaskEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String username;
    private List<TaskEntity> assignedTasks;
    public void setAssignedTasks(List<TaskDTO> collect) {
    }
}
