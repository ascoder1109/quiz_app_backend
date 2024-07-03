package com.example.quiz.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.quiz.quizapp.dao.QuizDao;
import com.example.quiz.quizapp.models.QuestionWrapper;
import com.example.quiz.quizapp.models.QuizModel;
import com.example.quiz.quizapp.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.quiz.quizapp.dao.QuestionDao;

import com.example.quiz.quizapp.models.QuestionModel;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {

        List<QuestionModel> questions = questionDao.findRandomQuestionsByCategory(category, numberOfQuestions);

        QuizModel quizModel = new QuizModel();
        quizModel.setTitle(title);
        quizModel.setQuestions(questions);


        quizDao.save(quizModel);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<QuizModel> quizModel = quizDao.findById(id);
        List<QuestionModel> questionsFromDB = quizModel.get().getQuestions();
        List<QuestionWrapper> questionForUsers = new ArrayList<>();
        for (QuestionModel q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_text(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUsers.add(qw);
        }

        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<ResponseModel> responses) {
        QuizModel quizModel = quizDao.findById(id).get();
        List<QuestionModel> questionsFromDB = quizModel.getQuestions();
        int right = 0;
        int i = 0;
        for(ResponseModel responseModel : responses) {
            if (responseModel.getResponse().equals(questionsFromDB.get(i).getCorrect_option())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
