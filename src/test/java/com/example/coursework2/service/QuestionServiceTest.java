package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class QuestionServiceTest {

    QuestionService questionService = new JavaQuestionService();

    @Test
    void getAll(){
        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        Question q2 = new Question("Какие целочисленные переменные вы знаете? ","byte, short, int, long");
        questionService.add(q1);
        questionService.add(q2);
        List<Question> expected = Arrays.asList(q1,q2);

        assertEquals(2,questionService.getAll().size());
        assertIterableEquals(expected, questionService.getAll());
    }

    @Test
    void add(){
        int prevSize = questionService.getAll().size();

        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        questionService.add(q1);

        assertEquals(prevSize + 1, questionService.getAll().size());
        assertTrue(questionService.getAll().contains(q1));
    }

    @Test
    void remove(){
        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        questionService.add(q1);

        assertTrue(questionService.getAll().contains(q1));

        questionService.remove(new Question("Какие циклы вы знаете? ","for, while, do-while"));
        assertFalse(questionService.getAll().contains(q1));
    }
}
