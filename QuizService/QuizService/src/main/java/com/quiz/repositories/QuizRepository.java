package com.quiz.repositories;

import com.quiz.entites.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository  extends JpaRepository<Quiz,Long> {
}
