package com.example.task_service.service;

import com.example.task_service.dto.UserDTO;
import com.fasterxml.jackson.databind.JsonNode;

public interface UserEventService {
    void handleUserCreated(UserDTO user);
}
