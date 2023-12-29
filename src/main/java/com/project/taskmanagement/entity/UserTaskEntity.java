package com.project.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_task")
public class UserTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_task_id")
    private Long userTaskId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    @Column(name = "role", nullable = false)
    private String role;

}
