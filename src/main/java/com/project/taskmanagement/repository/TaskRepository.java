package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    
}
