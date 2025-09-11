package com.example.task_service.service;


import com.example.task_service.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task addTask(Task task);
    List<Task> getTasks();

    Optional<Task> getTaskById(Long id);

    Task updateTask(Task task);

    String deleteTask(Long tid);


}
