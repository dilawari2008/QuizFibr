package com.example.Quiz.module.quiz.controller;

import com.example.Quiz.module.quiz.dto.ParticipationDto;
import com.example.Quiz.module.quiz.dto.QuizDto;
import com.example.Quiz.module.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class QuizParticipantController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quizes/{code}")
    public ResponseEntity<QuizDto> getQuizByCode(@PathVariable String code){
        return quizService.getQuizByCode(code);
    }

    @PostMapping("/quizes/{code}")
    public ResponseEntity evaluateQuiz(@PathVariable String code, @RequestBody ParticipationDto participationDto){
        return quizService.evaluateQuiz(code, participationDto);
    }
}
