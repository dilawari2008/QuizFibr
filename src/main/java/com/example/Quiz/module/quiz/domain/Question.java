package com.example.Quiz.module.quiz.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "quiz_id", "qn_num" }) })
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(name = "qn_num", nullable = false)
    private Long qnNum;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("question")
    @JoinColumn(name = "question_id")
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
