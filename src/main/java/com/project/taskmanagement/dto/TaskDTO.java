package com.project.taskmanagement.dto;

import java.time.LocalDate;
import java.util.Set;

import com.project.taskmanagement.entity.Priority;
import com.project.taskmanagement.entity.Status;
import com.project.taskmanagement.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {
    private Long taskId;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    private LocalDate createdDate;
    private LocalDate completedDate;
    private Set<UserEntity> assignedUsers;
}
