package com.example.quiz.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quiz.quizapp.models.QuestionModel;


@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer>{
    List<QuestionModel> findByCategory(String category);


@Query(value = "SELECT * FROM quiz_questions  WHERE category = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<QuestionModel> findRandomQuestionsByCategory(String category, int numberOfQuestions);
}
    

