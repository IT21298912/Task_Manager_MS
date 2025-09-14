package com.example.discovery.service;

import com.example.discovery.dto.TaskDTO;
import com.example.discovery.model.User;
import com.example.discovery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User findUserById(String id){
        User user = new User();
        user = userRepository.findUserById(Long.valueOf(id));



//        publisher.
        return user;
    }
}
