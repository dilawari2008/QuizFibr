package com.example.Quiz.module.quiz.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Quiz not found")
public class QuizNotFoundException extends Exception{
    public QuizNotFoundException(String message){
        super(message);
    }
}
