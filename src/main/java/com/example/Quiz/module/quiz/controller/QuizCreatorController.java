package com.example.Quiz.module.quiz.controller;

import com.example.Quiz.module.quiz.domain.Quiz;
import com.example.Quiz.module.quiz.dto.QuizDto;
import com.example.Quiz.module.quiz.dto.SubmisionsDto;
import com.example.Quiz.module.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class QuizCreatorController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/quizes")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/quizes/submissions/{code}")
    public ResponseEntity<SubmisionsDto> getQuizSubmissionsByCode(@PathVariable String code){
        return quizService.getQuizSubmissionsByCode(code);
    }
}
