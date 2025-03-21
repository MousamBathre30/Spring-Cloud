package com.quiz.services;

import com.quiz.dto.QuizDTO;

import java.util.List;

public interface QuizService {
    QuizDTO addQuiz(QuizDTO quizDTO);
    List<QuizDTO> getAllQuizzes();
    QuizDTO getQuizById(Long id);
    QuizDTO updateQuiz(Long id, QuizDTO quizDTO);
    void deleteQuiz(Long id);
}
