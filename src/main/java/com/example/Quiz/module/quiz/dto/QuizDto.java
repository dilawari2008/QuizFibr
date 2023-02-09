package com.example.Quiz.module.quiz.dto;

import com.example.Quiz.module.quiz.domain.Question;
import com.example.Quiz.module.quiz.domain.Quiz;

import java.util.List;
import java.util.stream.Collectors;

public class QuizDto {
    private String code;
    private String title;
    private List<QuestionDto> questions;

    public QuizDto(Quiz quiz) {
        this.code = quiz.getCode();
        this.title = quiz.getTitle();
        this.questions = quiz.getQuestions().stream().map(question -> new QuestionDto(question)).collect(Collectors.toList());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
