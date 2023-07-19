package com.example.coursework2.service.impl;

import com.example.coursework2.exception.NotEnoughQuestionsException;
import com.example.coursework2.model.Question;
import com.example.coursework2.service.ExaminerService;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Random RANDOM = new Random();
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()){
        throw new NotEnoughQuestionsException();
        }
        return Stream.generate(() -> getRandomQuestionService().getRandomQuestion())
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
private QuestionService getRandomQuestionService(){
        switch (RANDOM.nextInt(2)){
            case 0:
                return javaQuestionService;
            case 1:
                return mathQuestionService;
            default:
                throw new RuntimeException();
        }
    }
}
