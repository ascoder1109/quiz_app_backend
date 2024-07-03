package com.example.quiz.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.quizapp.models.QuestionModel;
import com.example.quiz.quizapp.service.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController{
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){
        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionModel>> getQuestionCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionModel question){
        return  questionService.addQuestion(question);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody QuestionModel question){
        return questionService.deleteQuestion(question);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionModel question){
        return questionService.updateQuestion(question);
    }
}