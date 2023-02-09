package com.example.Quiz.module.quiz.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @OneToMany(mappedBy = "questionId", fetch = FetchType.EAGER)
    List<Option> options;

    @ManyToOne
    @JoinColumn(name = "quiz_id" , referencedColumnName = "id")
    private Quiz quizId;
}
