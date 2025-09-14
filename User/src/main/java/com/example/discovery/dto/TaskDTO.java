package com.example.discovery.dto;

public class TaskDTO {
    private Long id;
    private String taskname;
    private String description;
    private String status;
    private String doneBy;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String taskname, String description, String status, String doneBy) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.status = status;
        this.doneBy = doneBy;
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