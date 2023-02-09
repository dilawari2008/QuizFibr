package com.example.Quiz.module.quiz.dto;

import com.example.Quiz.module.quiz.domain.Participation;
import com.example.Quiz.module.quiz.domain.Quiz;

import java.util.List;

public class SubmisionsDto {

    private Long creatorId;
    private String title;
    private String code;

    private List<Participation> participations;

    public SubmisionsDto(Long creatorId, String title, String code, List<Participation> participations) {
        this.creatorId = creatorId;
        this.title = title;
        this.code = code;
        this.participations = participations;
    }

    public SubmisionsDto(Quiz quiz) {
        this.creatorId = quiz.getCreatorId();
        this.title = quiz.getTitle();
        this.code = quiz.getCode();
        this.participations = quiz.getParticipations();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
