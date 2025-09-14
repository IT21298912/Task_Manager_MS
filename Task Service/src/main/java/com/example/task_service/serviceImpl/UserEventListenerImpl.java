package com.example.task_service.serviceImpl;

import com.example.task_service.dto.UserDTO;
import com.example.task_service.model.Task;
import com.example.task_service.service.TaskService;
import com.example.task_service.service.UserEventService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventListenerImpl implements UserEventService {

    @Autowired
    private TaskService taskService;


    @Override
    public void handleUserCreated(UserDTO user) {
       // System.out.println("Received user.created event: " + user);

        Task deftask = new Task();
        if (user.getId() != null) {
            String userId = user.getId();
            String username = user.getUname();

            //Auto Create Default Tasks
            deftask.setTaskname("Complete Your Profile");
            deftask.setDoneBy("NA");
            deftask.setStatus("Pending");
            deftask.setDescription("Complete your profile first for identify your roles");
            deftask.setUser(username);

            taskService.addTask(deftask);

            System.out.println("User ID: " + userId);

            // TODO: Add business logic here, e.g., create default tasks for this user
        } else {
            System.out.println("No user ID found in the event!");
        }
    }
}
