package com.example.quiz.quizapp.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@RequiredArgsConstructor
public class ResponseModel {
    private Integer id;
    private String response;
}
