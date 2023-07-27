package com.example.coursework2.repository;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.impl.JavaQuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionRepositoryTest {
    QuestionRepository questionRepository =  new JavaQuestionRepository();

    @Test
    void getAll(){
        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        Question q2 = new Question("Какие целочисленные переменные вы знаете? ","byte, short, int, long");
        questionRepository.add(q1);
        questionRepository.add(q2);
        List<Question> expected = Arrays.asList(q1,q2);

        assertEquals(2,questionRepository.getAll().size());
        assertIterableEquals(expected, questionRepository.getAll());
    }

    @Test
    void add(){
        int prevSize = questionRepository.getAll().size();

        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        questionRepository.add(q1);

        assertEquals(prevSize + 1, questionRepository.getAll().size());
        assertTrue(questionRepository.getAll().contains(q1));
    }

    @Test
    void remove(){
        Question q1 = new Question("Какие циклы вы знаете? ","for, while, do-while");
        questionRepository.add(q1);

        assertTrue(questionRepository.getAll().contains(q1));

        questionRepository.remove(new Question("Какие циклы вы знаете? ","for, while, do-while"));
        assertFalse(questionRepository.getAll().contains(q1));
    }
    
}
