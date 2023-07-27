package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import com.example.coursework2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    QuestionRepository questionRepository;
    @InjectMocks
    JavaQuestionService questionService;

    @Test
    public void RandomQuestion(){
        List<Question> questions = List.of(new Question("12132254","3425446"),
        new Question("121323424","25446"));
        when(questionRepository.getAll()).thenReturn(questions);
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(questions.contains(randomQuestion));
    }
}
