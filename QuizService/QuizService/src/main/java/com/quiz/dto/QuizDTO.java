package com.quiz.dto;

import com.question.dto.QuestionDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QuizDTO {
    private Long id;
    private String title;
    private List<QuestionDTO> questions; // ✅ Correct type

    // ✅ Corrected Constructor
    public QuizDTO(Long id, String title, List<QuestionDTO> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions; // ✅ Fixed variable assignment
    }

    // ✅ Another constructor for cases where questions are not needed
    public QuizDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
