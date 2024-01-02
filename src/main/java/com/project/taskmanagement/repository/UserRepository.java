package com.project.taskmanagement.repository;

import com.project.taskmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
   
}