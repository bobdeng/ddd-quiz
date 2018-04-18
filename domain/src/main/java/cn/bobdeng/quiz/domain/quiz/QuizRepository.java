package cn.bobdeng.quiz.domain.quiz;

import cn.bobdeng.quiz.domain.entity.QuestionInBank;
import cn.bobdeng.quiz.domain.entity.Quiz;

import java.util.List;


public interface QuizRepository {

    List<String> getAllQuestionsIdInBank();

    void saveQuiz(Quiz quiz);

    Quiz getQuizById(String id);

    void updateRank(Quiz quiz);

    int getRank(Quiz quiz);

    QuestionInBank findQuestionInBankById(String questionId);
}
