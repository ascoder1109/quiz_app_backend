package com.example.quiz.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.quizapp.dao.QuestionDao;
import com.example.quiz.quizapp.models.QuestionModel;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<QuestionModel>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
    
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<QuestionModel>> getQuestionsByCategory(String category) {
        try {
            
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<String> addQuestion(QuestionModel question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Add question failed", HttpStatus.BAD_REQUEST);
        // return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<String> deleteQuestion(QuestionModel question) {
        try {
            questionDao.delete(question);
            return new ResponseEntity<>("delete success", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return "Delete Success";
        return new ResponseEntity<>("Delete question failed", HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<String> updateQuestion(QuestionModel question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("update success", HttpStatus.ACCEPTED);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Update failed", HttpStatus.BAD_REQUEST);
        // return "Update Success";
    }
    
    
}
