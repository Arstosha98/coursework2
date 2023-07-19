package com.example.coursework2.repository.impl;

import com.example.coursework2.exception.QuestionAlreadyExistsException;
import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final List<Question> questions = new ArrayList<>();
    @Override
    public Question add(Question question) {
        if (questions.contains(question)){
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)){
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }
}
