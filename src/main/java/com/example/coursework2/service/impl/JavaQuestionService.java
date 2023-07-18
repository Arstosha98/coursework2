package com.example.coursework2.service.impl;

import com.example.coursework2.exception.QuestionAlreadyExistsException;
import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    public static final Random RANDOM = new Random();
    List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)){
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)){
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(RANDOM.nextInt(questions.size()));
    }
}
