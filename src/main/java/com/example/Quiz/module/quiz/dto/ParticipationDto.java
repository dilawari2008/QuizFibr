package com.example.Quiz.module.quiz.dto;

import java.util.List;

public class ParticipationDto {

    private String username;
    private List<AnswerDto> answers;

    public ParticipationDto(String username, List<AnswerDto> answers) {
        this.username = username;
        this.answers = answers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
