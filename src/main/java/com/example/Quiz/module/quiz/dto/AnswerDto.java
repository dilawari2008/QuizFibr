package com.example.Quiz.module.quiz.dto;

import java.util.List;

public class AnswerDto {
    private Long qnNum;
    private List<Long> options;

    public AnswerDto(Long qnNum, List<Long> options) {
        this.qnNum = qnNum;
        this.options = options;
    }

    public Long getQnNum() {
        return qnNum;
    }

    public void setQnNum(Long qnNum) {
        this.qnNum = qnNum;
    }

    public List<Long> getOptions() {
        return options;
    }

    public void setOptions(List<Long> options) {
        this.options = options;
    }
}
