package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import com.example.coursework2.service.impl.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;
    @InjectMocks
    MathQuestionService questionService;

    @Test
    void RandomQuestion(){
        List<Question> questions = List.of(new Question("1+1","2"),
                new Question("100-99","1"));
        when(questionRepository.getAll()).thenReturn(questions);
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(questions.contains(randomQuestion));
    }
}
