package com.example.Quiz.module.quiz.repository;

import com.example.Quiz.module.quiz.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
