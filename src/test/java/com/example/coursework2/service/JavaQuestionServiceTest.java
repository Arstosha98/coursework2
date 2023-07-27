package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import com.example.coursework2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    QuestionRepository questionRepository;
    @InjectMocks
    JavaQuestionService questionService;

    @Test
    void RandomQuestion(){List<Question> questions = List.of(new Question("Какие циклы вы знаете? ","for, while, do-while"),
                                                        new Question("Какие примитивы вы знаете?","byte, short, int, long"));
        when(questionRepository.getAll()).thenReturn(questions);
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(questions.contains(randomQuestion));
    }
}
