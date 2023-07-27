package com.example.coursework2.repository;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.impl.MathQuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionRepositoryTest {

    QuestionRepository questionRepository = new MathQuestionRepository();

    @Test
    void getAll(){
        Question q1 = new Question("1+1","2");
        Question q2 = new Question("100-99","1");
        questionRepository.add(q1);
        questionRepository.add(q2);
        List<Question> expected = Arrays.asList(q1,q2);

        assertEquals(2,questionRepository.getAll().size());
        assertIterableEquals(expected, questionRepository.getAll());
    }

    @Test
    void add(){
        int prevSize = questionRepository.getAll().size();

        Question q1 = new Question("1+1","2");
        questionRepository.add(q1);

        assertEquals(prevSize + 1, questionRepository.getAll().size());
        assertTrue(questionRepository.getAll().contains(q1));
    }

    @Test
    void remove(){
        Question q1 = new Question("1+1","2");
        questionRepository.add(q1);

        assertTrue(questionRepository.getAll().contains(q1));

        questionRepository.remove(new Question("1+1","2"));
        assertFalse(questionRepository.getAll().contains(q1));
    }
}
