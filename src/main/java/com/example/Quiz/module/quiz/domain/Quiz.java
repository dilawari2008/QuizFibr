package com.example.Quiz.module.quiz.domain;

import com.example.Quiz.module.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long creatorId;

    @Column(unique=true)
    private String code;

    private String title;

    @OneToMany(mappedBy = "quizId", fetch = FetchType.EAGER)
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quiz_participants",
            joinColumns = {@JoinColumn(name = "quiz_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id", referencedColumnName = "id")})
    private List<User> participants;
}
