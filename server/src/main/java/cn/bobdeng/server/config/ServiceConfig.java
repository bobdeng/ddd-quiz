package cn.bobdeng.server.config;

import cn.bobdeng.quiz.domain.quiz.QuizRepository;
import cn.bobdeng.quiz.domain.quiz.QuizService;
import cn.bobdeng.quiz.domain.quiz.impl.QuizServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    QuizService quizService(QuizRepository quizRepository) {
        QuizServiceImpl quizService = new QuizServiceImpl();
        quizService.setQuizRepository(quizRepository);
        return quizService;
    }
}
