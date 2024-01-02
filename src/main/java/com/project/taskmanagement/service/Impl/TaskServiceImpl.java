package com.project.taskmanagement.service.impl;

import com.project.taskmanagement.converter.TaskConverter;
import com.project.taskmanagement.dto.TaskDTO;
import com.project.taskmanagement.entity.TaskEntity;
import com.project.taskmanagement.repository.TaskRepository;
import com.project.taskmanagement.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskConverter taskConverter;

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskConverter::convertEntitytoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(Long taskId) {
        TaskEntity task = taskRepository.findById(taskId).orElse(null);
        return (task != null) ? taskConverter.convertEntitytoDTO(task) : null;
    }

    @Override
    public TaskDTO createTask(TaskDTO newTask) {
        TaskEntity task = taskConverter.convertDTOtoEntity(newTask);
        TaskEntity savedTask = taskRepository.save(task);
        return taskConverter.convertEntitytoDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long taskId, TaskDTO updatedTask) {
        TaskEntity existingTask = taskRepository.findById(taskId).orElse(null);
        if (existingTask != null) {
            taskConverter.convertDTOtoEntity(updatedTask);
            TaskEntity updatedTaskEntity = taskRepository.save(existingTask);
            return taskConverter.convertEntitytoDTO(updatedTaskEntity);
        } else {
            return null; 
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
