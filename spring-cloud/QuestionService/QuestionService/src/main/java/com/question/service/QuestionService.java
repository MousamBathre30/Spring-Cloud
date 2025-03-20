package com.question.service;

import com.question.entites.Question;
import com.question.repositories.QuestionRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements QuestionInterface {

    private final QuestionRepos questionRepos;

    public QuestionService(QuestionRepos questionRepos) {
        this.questionRepos = questionRepos;
    }

    public Question create(Question question) {
        return questionRepos.save(question);
    }

    public List<Question> get() {
        return questionRepos.findAll();
    }

    public Question getOne(Long questionId) {
        return questionRepos.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizID) {
        return questionRepos.findByQuizId(quizID);
    }





}
