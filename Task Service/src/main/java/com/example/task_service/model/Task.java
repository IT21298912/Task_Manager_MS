package com.example.task_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ Auto-generate numeric ID
    private Long id;
    @Column(nullable = false)
    private String taskname;
    @Column(nullable = false)
    private String description;
    private String status;

    private String doneBy;

    public Task(Long id, String taskname, String description, String status, String doneBy) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.status = status;
        this.doneBy = doneBy;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }
}
