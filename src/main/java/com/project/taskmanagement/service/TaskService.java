package com.project.taskmanagement.service;

import com.project.taskmanagement.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getAllTasks();

    TaskDTO getTaskById(Long taskId);

    TaskDTO createTask(TaskDTO newTask);

    TaskDTO updateTask(Long taskId, TaskDTO updatedTask);

    void deleteTask(Long taskId);
}
