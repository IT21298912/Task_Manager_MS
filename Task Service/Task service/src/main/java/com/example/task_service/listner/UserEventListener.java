package com.example.task_service.listner;

import com.example.task_service.dto.UserDTO;
import com.example.task_service.service.UserEventService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    private final UserEventService userEventService;

    public UserEventListener(UserEventService userEventService) {
        this.userEventService = userEventService;
    }

    @RabbitListener(queues = "user.queue", containerFactory = "rabbitListenerContainerFactory")
    public void onMessage(UserDTO user) {
        userEventService.handleUserCreated(user);
    }

}
