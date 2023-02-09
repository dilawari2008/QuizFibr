package com.example.Quiz.module.quiz.domain;

import javax.persistence.*;

@Entity
@Table(name = "quiz_participants")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id" , referencedColumnName = "id")
    private Quiz quizId;

    private Long participant_id;

    private Long score;

    //for storing answers of each submission
    //private String submission;
}
