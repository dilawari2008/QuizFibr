package com.example.Quiz.module.user.auth;

import com.example.Quiz.module.user.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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
        com.example.Quiz.module.user.User user = new com.example.Quiz.module.user.User(username, password, name);
        userRepository.save(user);
        return login(username, password);
    }

    public Optional findByToken(String token) {
        Optional user= userRepository.findByToken(token);
        if(user.isPresent()){
            com.example.Quiz.module.user.User user1 = (com.example.Quiz.module.user.User) user.get();
            org.springframework.security.core.userdetails.User user2= new User(user1.getUsername(), user1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user2);
        }
        return  Optional.empty();
    }
}
