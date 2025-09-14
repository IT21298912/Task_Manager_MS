package com.example.task_service.controller;

import com.example.task_service.model.Task;
import com.example.task_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class taskController {
    @Autowired
    private TaskService taskService;
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/{tid}")
    public Optional<Task> getTask(@PathVariable String tid){
        return taskService.getTaskById(Long.valueOf(tid));
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }
    @GetMapping
    public List<Task> getAlltasks(){
        return taskService.getTasks();
    }
    @DeleteMapping("/{tid}")
    public String deleteTask(@PathVariable String tid){
        return taskService.deleteTask(Long.valueOf(tid));
    }

    @GetMapping("/doneby/{uname}")
    public List<Task> doneBy(@PathVariable String uname){

        return taskService.getTaskDoneby(uname);
    }

}
