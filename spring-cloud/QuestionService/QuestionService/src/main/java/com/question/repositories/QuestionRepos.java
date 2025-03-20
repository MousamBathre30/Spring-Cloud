package com.question.repositories;

import com.question.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepos extends JpaRepository<Question , Long> {
    List<Question> findByQuizId(Long quizId);
}
