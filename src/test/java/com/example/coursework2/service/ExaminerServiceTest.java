package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    List<Question> questions = Arrays.asList(
            new Question("Какие циклы вы знаете? ","for, while, do-while"),
            new Question("1+1 ","2"),
            new Question("Какие условные операторы вы знаете? ","if, else, switch, else if, if-if")
    );
    @BeforeEach
    void setup(){
        when(questionService.getAll()).thenReturn(questions);
    }
    @Test
    void getQuestion(){
        int amount = 3;
        when(questionService.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1))
                .thenReturn(questions.get(2));

        Collection<Question> result = examinerService.getQuestion(amount);

        assertEquals(amount, result.size());
        assertTrue(result.contains(questions.get(0)));
        assertTrue(result.contains(questions.get(1)));
        assertTrue(result.contains(questions.get(2)));
    }
}
