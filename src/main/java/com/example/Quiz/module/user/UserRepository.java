package com.example.Quiz.module.user;

import com.example.Quiz.module.quiz.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select c from User c where c.username = ?1")
    User getUserByUsername(String username);

    @Query(value = "SELECT u FROM User u where u.username = ?1 and u.password = ?2 ")
    Optional<User> login(String username, String password);

    @Query(value = "SELECT u FROM User u where u.token = ?1")
    Optional<User> findByToken(String token);
}
