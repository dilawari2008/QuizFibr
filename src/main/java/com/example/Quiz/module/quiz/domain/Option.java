package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    private String option;

    @JsonProperty(value="isAns")
    private boolean isAns;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Option() {
    }

    public Option(Long id, String option, boolean isAns, Question questionId) {
        this.id = id;
        this.option = option;
        this.isAns = isAns;
        this.question = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean getAns() {
        return isAns;
    }

    public void setAns(boolean ans) {
        isAns = ans;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
