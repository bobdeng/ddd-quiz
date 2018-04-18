package cn.bobdeng.server.controller.quiz;

import cn.bobdeng.quiz.domain.quiz.QuizRepository;
import cn.bobdeng.server.controller.quiz.facade.QuizDTO;
import cn.bobdeng.server.controller.quiz.facade.QuizServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @Autowired
    QuizServiceFacade quizServiceFacade;

    @PostMapping("/create")
    public QuizDTO createNewQuiz() {
        return quizServiceFacade.createNewQuiz();
    }

    @GetMapping("/quiz/{id}")
    public QuizDTO getQuiz(@PathVariable("id") String id) {
        return quizServiceFacade.getQuiz(id);
    }

    @PostMapping("/submit_answer/{id}")
    public QuizDTO submitAnswer(@PathVariable("id") String id, @RequestParam("selected")int selected){
        return quizServiceFacade.submitAnswer(id,selected);
    }
}
