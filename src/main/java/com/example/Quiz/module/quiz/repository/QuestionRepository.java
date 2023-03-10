package com.example.Quiz.module.quiz.repository;

import com.example.Quiz.module.quiz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
