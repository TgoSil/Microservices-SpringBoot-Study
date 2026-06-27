package com.tiago.auth_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiago.auth_service.domain.entities.User;
import com.tiago.auth_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        // if (user.isEmpty()) System.out.println("vazio q bad \n\n\n\n\n\n\n\n\n\n");
        return user;
    }

}
