package com.project.taskmanagement.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String username;
    private List<TaskDTO> assignedTasks;
    
}
