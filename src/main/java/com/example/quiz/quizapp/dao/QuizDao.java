package com.example.quiz.quizapp.dao;

import com.example.quiz.quizapp.models.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<QuizModel,Integer> {

}
