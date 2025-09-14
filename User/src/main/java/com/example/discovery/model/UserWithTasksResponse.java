package com.example.discovery.model;


import com.example.discovery.dto.TaskDTO;

import java.util.List;

public record UserWithTasksResponse(User user, List<TaskDTO> tasks) {}
