package com.example.Quiz.module.quiz.service;

import com.example.Quiz.module.quiz.domain.Quiz;
import com.example.Quiz.module.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<Quiz> addQuiz(Quiz quiz){
        quizRepository.save(quiz);
        return ResponseEntity.ok(quiz);
    }
}
