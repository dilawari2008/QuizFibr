package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Quiz quiz;

    @Column(nullable = false)
    private String participantName;

    @Column(nullable = false)
    private Long score;

    //for storing answers of each submission
    //private String submission;


    public Participation() {
    }

    public Participation(Long id, Quiz quizId, String participantName, Long score) {
        this.id = id;
        this.quiz = quizId;
        this.participantName = participantName;
        this.score = score;
    }

    public Participation(Quiz quiz, String participantName, Long score) {
        this.quiz = quiz;
        this.participantName = participantName;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
