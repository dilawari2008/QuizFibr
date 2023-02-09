package com.example.Quiz.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
