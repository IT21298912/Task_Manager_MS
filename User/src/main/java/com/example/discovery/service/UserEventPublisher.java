package com.example.discovery.service;

import com.example.discovery.dto.UserDTO;
import com.example.discovery.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final Jackson2JsonMessageConverter jsonConverter;
    private final RabbitTemplate rabbitTemplate;
    public UserEventPublisher(Jackson2JsonMessageConverter jsonConverter, RabbitTemplate rabbitTemplate) {
        this.jsonConverter = jsonConverter;
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishUserCreated(UserDTO user) {
        rabbitTemplate.setMessageConverter(jsonConverter);

        // Send user object as JSON to exchange
        rabbitTemplate.convertAndSend("user.exchange", "user.created", user);

        System.out.println("Published user.created event: " + user.getId());
    }
}
