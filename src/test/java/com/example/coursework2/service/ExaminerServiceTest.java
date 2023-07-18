package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerService examinerService;

    List<Question> questions = Arrays.asList(
            new Question("Какие циклы вы знаете? ","for, while, do-while"),
            new Question("Какие целочисленные переменные вы знаете? ","byte, short, int, long"),
            new Question("Какие условные операторы вы знаете? ","if, else, switch, else if, if-if")
    );
    @BeforeEach
    void setup(){
        when(questionService.getAll()).thenReturn(questions);
    }
    @Test
    void getQuestion(){
//        Question actual = ;
//        Question expected = ;

//        Подскажите как выглядит тест к этому методу
    }
}
