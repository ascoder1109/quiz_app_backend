package com.example.quiz.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "quiz_questions") 
public class QuestionModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
//    private String title;
    private String question_text;
    private String difficulty_level;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_option;
}
