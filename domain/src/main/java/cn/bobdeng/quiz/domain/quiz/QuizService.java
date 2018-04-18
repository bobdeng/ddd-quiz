package cn.bobdeng.quiz.domain.quiz;


import cn.bobdeng.quiz.domain.entity.Question;
import cn.bobdeng.quiz.domain.entity.QuestionInBank;
import cn.bobdeng.quiz.domain.entity.Quiz;

public interface QuizService {

    Quiz createNewQuiz(int questionCount);

    QuestionInBank getQuestionInBank(String questionId);

    Quiz submitAnswer(String quizId, int answer);

    QuizResult getQuizResult(String quizId);

    Quiz getQuiz(String id);
}
