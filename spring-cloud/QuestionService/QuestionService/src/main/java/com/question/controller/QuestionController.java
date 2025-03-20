package com.question.controller;

import com.question.dto.QuestionDTO;
import com.question.entites.Question;
import com.question.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionDTO questionDTO) {
        Question savedQuestion = questionService.create(dtoToEntity(questionDTO));
        return ResponseEntity.status(201).body(entityToDTO(savedQuestion));
    }

    @GetMapping("/get")
    public ResponseEntity<List<QuestionDTO>> getAll() {
        List<QuestionDTO> questionDTOs = questionService.get().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(questionDTOs);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable Long id) {
        Question question = questionService.getOne(id);
        return ResponseEntity.ok(entityToDTO(question));
    }

    // ✅ This endpoint is required for Feign Client
    @GetMapping("/quiz/{quizID}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsOfQuiz(@PathVariable Long quizID) {
        List<QuestionDTO> questionDTOs = questionService.getQuestionsOfQuiz(quizID)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(questionDTOs);
    }

    private Question dtoToEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setQuestionId(questionDTO.getQuestionId());
        question.setQuestion(questionDTO.getQuestion());
        question.setQuizId(questionDTO.getQuizId());
        return question;
    }

    private QuestionDTO entityToDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionId(question.getQuestionId());
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setQuizId(question.getQuizId());
        return questionDTO;
    }
}
