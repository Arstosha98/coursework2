package com.example.coursework2.service.impl;

import com.example.coursework2.exception.NotAllowedException;
import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    public static final Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new NotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new NotAllowedException();
    }
    @Override
    public Question remove(String question, String answer) {
        throw new NotAllowedException();
    }

    @Override
    public Question remove(Question question){
        throw new NotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new NotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        int a = RANDOM.nextInt(100);
        int b = RANDOM.nextInt(100);

        return switch (RANDOM.nextInt(4)) {
            case 0 -> new Question(a + " - " + b, String.valueOf(a - b));
            case 1 -> new Question(a + " / " + b, String.valueOf(a / b));
            case 2 -> new Question(a + " + " + b, String.valueOf(a + b));
            case 3 -> new Question(a + " * " + b, String.valueOf(a * b));
            default -> throw new RuntimeException();
        };
    }
}
