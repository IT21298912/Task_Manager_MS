package com.example.discovery.controller;

import com.example.discovery.dto.AuthRequest;
import com.example.discovery.dto.TaskDTO;
import com.example.discovery.dto.UserDTO;
import com.example.discovery.model.User;
import com.example.discovery.model.UserWithTasksResponse;
import com.example.discovery.repository.UserRepository;
import com.example.discovery.security.JwtUtil;

import com.example.discovery.service.UserEventPublisher;
import com.example.discovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    private final UserEventPublisher publisher;

    private final RestTemplate restTemplate;






    public AuthController(UserEventPublisher publisher, RestTemplate restTemplate) {
        this.publisher = publisher;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepo.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setEmail(user.getEmail());
        userDTO.setUname(user.getUsername());
        publisher.publishUserCreated(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        UserDetails user = (UserDetails) auth.getPrincipal();
        String jwt = jwtUtil.generateToken(user);
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("task/{id}")
    public UserWithTasksResponse findUserwithTasks(@PathVariable String id){

        User user = new User();
        user= userService.findUserById(id);

        TaskDTO[] tasks = restTemplate.getForObject(
                "http://Task-service/task/doneby/" + user.getUsername(),
                TaskDTO[].class
        );

        return new UserWithTasksResponse(user, Arrays.asList(tasks));


    }
}

