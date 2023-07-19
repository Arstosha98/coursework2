package com.example.coursework2.service.impl;

import com.example.coursework2.exception.NotEnoughQuestionsException;
import com.example.coursework2.model.Question;
import com.example.coursework2.service.ExaminerService;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Random RANDOM = new Random();
    private final List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        return Stream.generate(() -> getRandomQuestionService().getRandomQuestion())
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
    private QuestionService getRandomQuestionService(){
        return questionServices.get(RANDOM.nextInt(questionServices.size()));
    }
}
