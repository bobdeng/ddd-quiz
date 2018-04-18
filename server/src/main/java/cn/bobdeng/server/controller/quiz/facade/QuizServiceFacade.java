package cn.bobdeng.server.controller.quiz.facade;

public interface QuizServiceFacade {
    QuizDTO createNewQuiz();

    QuizDTO getQuiz(String id);

    QuizDTO submitAnswer(String id, int selected);
}
