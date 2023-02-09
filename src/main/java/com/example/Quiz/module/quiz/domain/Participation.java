package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    private Long participant_id;

    private Long score;

    //for storing answers of each submission
    //private String submission;


    public Participation() {
    }

    public Participation(Long id, Quiz quizId, Long participant_id, Long score) {
        this.id = id;
        this.quiz = quizId;
        this.participant_id = participant_id;
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

    public Long getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Long participant_id) {
        this.participant_id = participant_id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
