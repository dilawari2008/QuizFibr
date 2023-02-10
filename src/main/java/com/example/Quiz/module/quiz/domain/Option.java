package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "options", uniqueConstraints = { @UniqueConstraint(columnNames = { "question_id", "option_num"}) })
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String option;

    @Column(name = "option_num", nullable = false)
    private Long optionNum;

    @JsonProperty(value="isAns")
    private boolean isAns;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Option() {
    }

    public Option(Long id, String option, Long optionNum, boolean isAns, Question question) {
        this.id = id;
        this.option = option;
        this.optionNum = optionNum;
        this.isAns = isAns;
        this.question = question;
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

    public Long getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(Long optionNum) {
        this.optionNum = optionNum;
    }

    public boolean isAns() {
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
