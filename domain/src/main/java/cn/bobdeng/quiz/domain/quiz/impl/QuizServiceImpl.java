package cn.bobdeng.quiz.domain.quiz.impl;

import cn.bobdeng.quiz.domain.entity.Question;
import cn.bobdeng.quiz.domain.entity.QuestionInBank;
import cn.bobdeng.quiz.domain.entity.Quiz;
import cn.bobdeng.quiz.domain.quiz.QuizRepository;
import cn.bobdeng.quiz.domain.quiz.QuizResult;
import cn.bobdeng.quiz.domain.quiz.QuizService;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;

    @Override
    public Quiz createNewQuiz(int size) {
        List<String> allQuestionsInBank = quizRepository.getAllQuestionsIdInBank();
        Quiz quiz = newQuizFromBank(size, allQuestionsInBank);
        quizRepository.saveQuiz(quiz);
        return quiz;
    }

    private Quiz newQuizFromBank(int size, List<String> allQuestionsInBank) {
        Collections.shuffle(allQuestionsInBank);
        return Quiz.of(allQuestionsInBank.stream()
                .map(Question::init)
                .limit(size)
                .collect(Collectors.toList()));
    }

    @Override
    public QuestionInBank getQuestionInBank(String questionId) {
        QuestionInBank questionInBank = quizRepository.findQuestionInBankById(questionId);
        return questionInBank;
    }


    @Override
    public Quiz submitAnswer(String quizId, int answer) {
        Quiz quiz = quizRepository.getQuizById(quizId);
        submitAnswer(answer, quiz);
        if (quiz.isOver()) {
            quizRepository.updateRank(quiz);
        }
        return quiz;
    }


    private void submitAnswer(int answer, Quiz quiz) {
        QuestionInBank questionInBank = quizRepository.findQuestionInBankById(quiz.getCurrentQuestion().getQuestionId());
        quiz.submitAnswerAndGoNext(answer, questionInBank);
        quizRepository.saveQuiz(quiz);
    }

    @Override
    public QuizResult getQuizResult(String quizId) {
        Quiz quiz = quizRepository.getQuizById(quizId);
        return getQuizResult(quiz);
    }

    private QuizResult getQuizResult(Quiz quiz) {
        return QuizResult.builder()
                .score(quiz.getScore())
                .id(quiz.getId())
                .rank(quizRepository.getRank(quiz))
                .build();
    }

}
