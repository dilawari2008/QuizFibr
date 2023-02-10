package com.example.Quiz.module.quiz.service;

import com.example.Quiz.module.quiz.CustomExceptions.QuizNotFoundException;
import com.example.Quiz.module.quiz.domain.Option;
import com.example.Quiz.module.quiz.domain.Participation;
import com.example.Quiz.module.quiz.domain.Question;
import com.example.Quiz.module.quiz.domain.Quiz;
import com.example.Quiz.module.quiz.dto.*;
import com.example.Quiz.module.quiz.repository.ParticipationRepository;
import com.example.Quiz.module.quiz.repository.QuizRepository;
import com.example.Quiz.module.user.User;
import com.example.Quiz.module.user.UserRepository;
import com.example.Quiz.module.user.auth.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    private static Logger log = LoggerFactory.getLogger(QuizService.class);

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    public ResponseEntity<Quiz> addQuiz(Quiz quiz){
        try {
            log.info("creating new quiz ---");
            log.debug(quiz.toString());
            User user = SecurityUtils.getCurrentUser();
            if (user == null) return new ResponseEntity("User not Found!", HttpStatus.BAD_REQUEST);
            quiz.setCreatorId(user.getId());
            Quiz quiz1 = quizRepository.getQuizByCode(quiz.getCode());
            if(quiz1 != null) return new ResponseEntity("Quiz code exists, please change the quiz code!",HttpStatus.BAD_REQUEST);
            quizRepository.save(quiz);
            log.info("quiz " + quiz.getCode() + " successfully created!");
            return ResponseEntity.ok(quiz);
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException", e);
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<QuizDto> getQuizByCode(String code){
        try {
            Quiz quiz = quizRepository.getQuizByCode(code);
            if (quiz == null)
                throw new QuizNotFoundException("quiz code " + code + " does not exist");
            QuizDto quizDto = new QuizDto(quiz);
            return ResponseEntity.ok(quizDto);
        } catch (QuizNotFoundException e) {
            log.error("QuizNotFoundException", e);
            return new ResponseEntity("quiz code " + code + " does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity evaluateQuiz(String code, ParticipationDto participationDto) {
        try {
            if (participationDto == null || participationDto.getParticipantName() == null || participationDto.getParticipantName().isEmpty())
                return new ResponseEntity("participantName " + participationDto.getParticipantName() + " empty/invalid", HttpStatus.BAD_REQUEST);
            Quiz quiz = quizRepository.getQuizByCode(code);
            if (quiz == null)
                throw new QuizNotFoundException("quiz code " + code + " does not exist");
            Map<Long, Boolean> isQnAnswered = new HashMap<>();
            Map<Long, Set<Long>> answerKey = new HashMap<>();
            Long score = 0L;

            for (Question question : quiz.getQuestions()) {
                if (!answerKey.containsKey(question.getQnNum())) {
                    answerKey.put(question.getQnNum(), new TreeSet<>());
                }

                for (Option option : question.getOptions()) {
                    if (option.isAns()) {
                        answerKey.get(question.getQnNum()).add(option.getOptionNum());
                    }
                }
            }

            if (!(participationDto.getAnswers() == null || participationDto.getAnswers().isEmpty())) {
                for (AnswerDto answer : participationDto.getAnswers()) {
                    Long qnNum = answer.getQnNum();
                    List<Long> options = answer.getOptions();

                    if (options == null) continue;
                    if (isQnAnswered.containsKey(qnNum) && isQnAnswered.get(qnNum) == true) continue;

                    isQnAnswered.put(qnNum, true);
                    Set<Long> optionSet = new TreeSet<>(options);
                    if (optionSet.equals(answerKey.get(qnNum))) score++;
                }
            }

            Participation participation = new Participation(quiz, participationDto.getParticipantName(), score);
            participationRepository.save(participation);


            return new ResponseEntity<>("your score is " + score + " out of " + quiz.getQuestions().size(), HttpStatus.OK);
        } catch (QuizNotFoundException e) {
            log.error("QuizNotFoundException", e);
            return new ResponseEntity("quiz code " + code + " does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<SubmisionsDto> getQuizSubmissionsByCode(String code){
        try {
            User user = SecurityUtils.getCurrentUser();
            if (user == null) return new ResponseEntity("User not Found!", HttpStatus.BAD_REQUEST);
            Quiz quiz = quizRepository.getQuizByCodeAndCreatorId(code, user.getId());
            if (quiz == null)
                throw new QuizNotFoundException("quiz code " + code + " does not exist");
            SubmisionsDto submisionsDto = new SubmisionsDto(quiz);
            return new ResponseEntity<>(submisionsDto, HttpStatus.OK);
        } catch (QuizNotFoundException e) {
            log.error("QuizNotFoundException", e);
            return new ResponseEntity("quiz code " + code + " does not exist", HttpStatus.BAD_REQUEST);
        }
    }

}
