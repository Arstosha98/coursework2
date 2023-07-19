package com.example.coursework2.repository;

import com.example.coursework2.model.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    List<Question> getAll();
}
