package com.example.quiz.quizapp.controller;

import com.example.quiz.quizapp.models.QuestionWrapper;
import com.example.quiz.quizapp.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quiz.quizapp.service.QuizService;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title){
        return quizService.createQuiz(category,numberOfQuestions,title);
//        return new ResponseEntity<>("I am here", HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<ResponseModel> responses){
        return quizService.calculateResult(id,responses);
    }
}
