package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("question")
    private Set<Option> options;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    public Question() {
    }

    public Question(Long id, String question, Set<Option> options, Quiz quizId) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.quiz = quizId;
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

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
