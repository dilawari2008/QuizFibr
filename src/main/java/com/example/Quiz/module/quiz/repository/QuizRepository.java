package com.example.Quiz.module.quiz.repository;

import com.example.Quiz.module.quiz.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query(value = "select c from Quiz c where c.code = ?1")
    Quiz getQuizByCode(String code);
}
