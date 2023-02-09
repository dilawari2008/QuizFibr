package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    private String question;

    private Long qnNum;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("question")
    private List<Option> options;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    public Question() {
    }

    public Question(Long id, String question, Long qnNum, List<Option> options, Quiz quiz) {
        this.id = id;
        this.question = question;
        this.qnNum = qnNum;
        this.options = options;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getQnNum() {
        return qnNum;
    }

    public void setQnNum(Long qnNum) {
        this.qnNum = qnNum;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
