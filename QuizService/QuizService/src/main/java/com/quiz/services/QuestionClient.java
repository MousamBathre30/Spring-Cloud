package com.quiz.services;


import com.question.dto.QuestionDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE", url = "http://localhost:8082/questions")
public interface QuestionClient {

    @GetMapping("/quiz/{quizID}")
    List<QuestionDTO> getQuestionsOfQuiz(@PathVariable("quizID") Long quizID);
}
