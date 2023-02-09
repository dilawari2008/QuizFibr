package com.example.Quiz.module.quiz.dto;

import com.example.Quiz.module.quiz.domain.Option;

public class OptionDto {
    private String option;
    private Long optionNum;

    public OptionDto(Option option) {
        this.option = option.getOption();
        this.optionNum = option.getOptionNum();
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
}
