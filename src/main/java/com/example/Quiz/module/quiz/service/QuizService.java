package com.example.Quiz.module.quiz.service;

import com.example.Quiz.module.quiz.domain.Quiz;
import com.example.Quiz.module.quiz.dto.QuestionDto;
import com.example.Quiz.module.quiz.dto.QuizDto;
import com.example.Quiz.module.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<Quiz> addQuiz(Quiz quiz){
        quizRepository.save(quiz);
        return ResponseEntity.ok(quiz);
    }

    public ResponseEntity<QuizDto> getQuizByCode( String code){
        Quiz quiz = quizRepository.getQuizByCode(code);
        QuizDto quizDto = new QuizDto(quiz);
        return ResponseEntity.ok(quizDto);
    }

}
