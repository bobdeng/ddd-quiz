package cn.bobdeng.server.controller.quiz.facade;

import cn.bobdeng.quiz.domain.entity.QuestionInBank;
import cn.bobdeng.quiz.domain.entity.Quiz;
import cn.bobdeng.quiz.domain.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceFacadeImpl implements QuizServiceFacade {
    public static final int QUESTION_COUNT = 30;
    @Autowired
    QuizService quizService;

    @Override
    public QuizDTO createNewQuiz() {
        Quiz newQuiz = quizService.createNewQuiz(QUESTION_COUNT);
        return getQuizDTO(newQuiz);
    }

    private QuizDTO getQuizDTO(Quiz newQuiz) {
        return QuizDTO.builder()
                .id(newQuiz.getId())
                .over(newQuiz.isOver())
                .progress(newQuiz.getProgress())
                .total(newQuiz.getQuestions().size())
                .currentQuestion(getQuestionInBank(newQuiz.getCurrentQuestion().getQuestionId()))
                .build();
    }

    private QuestionDTO getQuestionInBank(String questionId) {
        QuestionInBank questionInBank = quizService.getQuestionInBank(questionId);
        return QuestionDTO.builder()
                .options(questionInBank.getOptions())
                .question(questionInBank.getQuestion())
                .build();
    }

    @Override
    public QuizDTO getQuiz(String id) {
        Quiz quiz = quizService.getQuiz(id);
        return getQuizDTO(quiz);
    }

    @Override
    public QuizDTO submitAnswer(String id, int selected) {
        Quiz quiz = quizService.submitAnswer(id, selected);
        return getQuizDTO(quiz);
    }
}
