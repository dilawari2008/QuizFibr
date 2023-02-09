package com.example.Quiz.module.quiz.repository;

import com.example.Quiz.module.quiz.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
