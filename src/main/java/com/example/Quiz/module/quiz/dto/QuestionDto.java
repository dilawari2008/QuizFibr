package com.example.Quiz.module.quiz.dto;

import com.example.Quiz.module.quiz.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionDto {
    private Long qnNum;
    private String question;
    private List<OptionDto> options;

    public QuestionDto(Question question) {
        this.question = question.getQuestion();
        this.qnNum = question.getQnNum();
        this.options = question.getOptions().stream().map(option -> new OptionDto(option)).collect(Collectors.toList());
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

    public Long getQnNum() {
        return qnNum;
    }

    public void setQnNum(Long qnNum) {
        this.qnNum = qnNum;
    }
}
