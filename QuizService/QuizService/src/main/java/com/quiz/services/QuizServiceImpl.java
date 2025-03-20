package com.quiz.services;

import com.question.dto.QuestionDTO;
import com.quiz.dto.QuizDTO;
import com.quiz.entites.Question;
import com.quiz.entites.Quiz;
import com.quiz.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    // ✅ Corrected Constructor (Only Inject Repository)


    @Override
    public QuizDTO addQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getTitle());
        Quiz savedQuiz = quizRepository.save(quiz);
        return new QuizDTO(savedQuiz.getId(), savedQuiz.getTitle());
    }

    @Override
    public List<QuizDTO> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();

        return quizzes.stream().map(quiz -> {
            List<QuestionDTO> questionDTOs = questionClient.getQuestionsOfQuiz(quiz.getId());
            List<Question> questions = questionDTOs.stream().map(this::dtoToEntity).collect(Collectors.toList());

            return new QuizDTO(quiz.getId(), quiz.getTitle(), questionDTOs);
        }).collect(Collectors.toList());
    }

    @Override
    public QuizDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuestionDTO> questionDTOs = questionClient.getQuestionsOfQuiz(quiz.getId());
        List<Question> questions = questionDTOs.stream().map(this::dtoToEntity).collect(Collectors.toList());

        return new QuizDTO(quiz.getId(), quiz.getTitle(), questionDTOs);
    }

    private Question dtoToEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setQuestionId(questionDTO.getQuestionId());
        question.setQuestion(questionDTO.getQuestion());
        question.setQuizId(questionDTO.getQuizId());
        return question;
    }


    @Override
    public QuizDTO updateQuiz(Long id, QuizDTO quizDTO) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        quiz.setTitle(quizDTO.getTitle());
        Quiz updatedQuiz = quizRepository.save(quiz);
        return new QuizDTO(updatedQuiz.getId(), updatedQuiz.getTitle());
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
