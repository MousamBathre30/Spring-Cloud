package com.question.dto;

import com.fasterxml.jackson.annotation.JsonProperty;



public class QuestionDTO {
    @JsonProperty("question_id")
    private Long questionId;
    private String question;


    private Long quizId;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizID) {
        this.quizId = quizID;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
