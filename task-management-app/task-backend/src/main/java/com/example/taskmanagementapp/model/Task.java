package com.example.taskmanagementapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime beginTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    private String status;

    public boolean isCompleted() {
        return "completed".equals(status);
    }

    public void setCompleted(boolean completed) {
        status = completed ? "completed" : null;
    }
}
