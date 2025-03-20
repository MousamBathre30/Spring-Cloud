package com.quiz.controller;

import com.quiz.dto.QuizDTO;
import com.quiz.entites.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/add")
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody QuizDTO quizDTO) {
        return ResponseEntity.ok(quizService.addQuiz(quizDTO));
    }

    @GetMapping()
    public ResponseEntity<List<QuizDTO>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<QuizDTO> updateQuiz(@PathVariable Long id, @RequestBody QuizDTO quizDTO) {
        return ResponseEntity.ok(quizService.updateQuiz(id, quizDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok("Quiz deleted successfully");
    }
}
