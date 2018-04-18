package cn.bobdeng.server.service;

import cn.bobdeng.quiz.domain.entity.QuestionInBank;
import cn.bobdeng.quiz.domain.entity.Quiz;
import cn.bobdeng.quiz.domain.quiz.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 尚未实现，可以先写个内存里面的实现
 */
@Service
public class QuizMemoRepository implements QuizRepository {
    @Override
    public List<String> getAllQuestionsIdInBank() {
        return null;
    }

    @Override
    public void saveQuiz(Quiz quiz) {

    }

    @Override
    public Quiz getQuizById(String id) {
        return null;
    }

    @Override
    public void updateRank(Quiz quiz) {

    }

    @Override
    public int getRank(Quiz quiz) {
        return 0;
    }

    @Override
    public QuestionInBank findQuestionInBankById(String questionId) {
        return null;
    }
}
