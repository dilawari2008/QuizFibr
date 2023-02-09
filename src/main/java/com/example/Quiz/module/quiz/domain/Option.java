package com.example.Quiz.module.quiz.domain;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String option;

    private Boolean isAns;

    @ManyToOne
    @JoinColumn(name = "question_id" , referencedColumnName = "id")
    private Question questionId;
}
