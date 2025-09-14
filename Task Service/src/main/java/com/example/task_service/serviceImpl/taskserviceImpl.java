package com.example.task_service.serviceImpl;

import com.example.task_service.model.Task;
import com.example.task_service.repository.taskRepository;
import com.example.task_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class taskserviceImpl implements TaskService {

    @Autowired
   private taskRepository repository;
    @Override
    public Task addTask(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Task updateTask(Task task) {
        Task etask = repository.findById(task.getId()).orElse(null);

        if (etask!=null){
            etask.setTaskname(task.getTaskname());
            etask.setDescription(task.getDescription());
            etask.setStatus(task.getStatus());
            etask.setDoneBy(task.getDoneBy());

            return repository.save(etask);
        }
        return null;
    }

    @Override
    public String deleteTask(Long tid) {
        repository.deleteById(Long.valueOf(tid));
        return "Task Deleted!!";
    }

    @Override
    public List<Task> getTaskDoneby(String uname) {
        return repository.findByDoneBy(uname);
    }
}
