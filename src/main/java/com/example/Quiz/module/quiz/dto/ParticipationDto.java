package com.example.Quiz.module.quiz.dto;

import java.util.List;

public class ParticipationDto {

    private String participantName;
    private List<AnswerDto> answers;

    public ParticipationDto(String participantName, List<AnswerDto> answers) {
        this.participantName = participantName;
        this.answers = answers;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
