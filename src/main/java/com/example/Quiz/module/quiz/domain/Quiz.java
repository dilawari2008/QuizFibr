package com.example.Quiz.module.quiz.domain;

import com.example.Quiz.module.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long creatorId;

    @Column(unique=true)
    private String code;

    private String title;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("quiz")
    private Set<Question> questions;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Participation> participations;

    public Quiz() {
    }

    public Quiz(Long id, Long creatorId, String code, String title, Set<Question> questions, Set<Participation> participations) {
        this.id = id;
        this.creatorId = creatorId;
        this.code = code;
        this.title = title;
        this.questions = questions;
        this.participations = participations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<Participation> participations) {
        this.participations = participations;
    }


}
