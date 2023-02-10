package com.example.Quiz.module.user.auth;

import com.example.Quiz.module.user.User;
import com.example.Quiz.module.user.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import java.util.UUID;

@Service
public class UserAuthService {
    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        Optional user = userRepository.login(username,password);
        if(user.isPresent()){
            String token = UUID.randomUUID().toString();
            com.example.Quiz.module.user.User user1= (com.example.Quiz.module.user.User) user.get();
            user1.setToken(token);
            userRepository.save(user1);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Transactional
    public String register(String username, String password, String name) {
        User user = new User(username, password, name);
        userRepository.save(user);
        return login(username, password);
    }

    public Optional findByToken(String token) {
        Optional user= userRepository.findByToken(token);
        if(user.isPresent()){
            User user1 = (User) user.get();
            return Optional.of(user1);
        }
        return  Optional.empty();
    }
}
