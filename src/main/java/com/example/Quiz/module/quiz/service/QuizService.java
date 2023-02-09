package com.example.Quiz.module.quiz.service;

import com.example.Quiz.module.quiz.domain.Option;
import com.example.Quiz.module.quiz.domain.Participation;
import com.example.Quiz.module.quiz.domain.Question;
import com.example.Quiz.module.quiz.domain.Quiz;
import com.example.Quiz.module.quiz.dto.AnswerDto;
import com.example.Quiz.module.quiz.dto.ParticipationDto;
import com.example.Quiz.module.quiz.dto.QuestionDto;
import com.example.Quiz.module.quiz.dto.QuizDto;
import com.example.Quiz.module.quiz.repository.ParticipationRepository;
import com.example.Quiz.module.quiz.repository.QuizRepository;
import com.example.Quiz.module.user.User;
import com.example.Quiz.module.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    public ResponseEntity<Quiz> addQuiz(Quiz quiz){
        quizRepository.save(quiz);
        return ResponseEntity.ok(quiz);
    }

    public ResponseEntity<QuizDto> getQuizByCode( String code){
        Quiz quiz = quizRepository.getQuizByCode(code);
        QuizDto quizDto = new QuizDto(quiz);
        return ResponseEntity.ok(quizDto);
    }

    public ResponseEntity evaluateQuiz(String code, ParticipationDto participationDto) {
        if(participationDto == null || participationDto.getParticipantName()==null || participationDto.getParticipantName().isEmpty())
            return new ResponseEntity("participantName " + participationDto.getParticipantName() + " empty/invalid", HttpStatus.BAD_REQUEST);
        Quiz quiz = quizRepository.getQuizByCode(code);
        if(quiz == null) return new ResponseEntity("quiz code " + code + " does not exist", HttpStatus.BAD_REQUEST);
        Map<Long, Boolean> isQnAnswered = new HashMap<>();
        Map<Long, Set<Long>> answerKey = new HashMap<>();
        Long score = 0L;

        for(Question question : quiz.getQuestions()) {
            if(!answerKey.containsKey(question.getQnNum())) {
                answerKey.put(question.getQnNum(), new TreeSet<>());
            }

            for(Option option : question.getOptions()) {
                if(option.isAns()){
                    answerKey.get(question.getQnNum()).add(option.getOptionNum());
                }
            }
        }

        if(!(participationDto.getAnswers() == null ||  participationDto.getAnswers().isEmpty())) {
            for(AnswerDto answer : participationDto.getAnswers()) {
                Long qnNum = answer.getQnNum();
                List<Long> options = answer.getOptions();

                if(options == null || options.isEmpty()) continue;
                if(isQnAnswered.containsKey(qnNum) && isQnAnswered.get(qnNum) == true) continue;

                isQnAnswered.put(qnNum, true);
                Set<Long> optionSet = new TreeSet<>(options);
                if(optionSet.equals(answerKey.get(qnNum))) score++;
            }
        }

        Participation participation = new Participation(quiz, participationDto.getParticipantName(), score);
        participationRepository.save(participation);



        return new ResponseEntity<>("your score is " + score + " out of " + quiz.getQuestions().size(),HttpStatus.OK);
    }

}
