package com.question.service;

import com.question.entites.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionInterface {
    Question create(Question question);

    List<Question> get();

    Question getOne(Long id);

    List<Question> getQuestionsOfQuiz(Long quizID);
}
