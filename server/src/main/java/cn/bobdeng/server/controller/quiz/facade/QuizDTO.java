package cn.bobdeng.server.controller.quiz.facade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String id;
    private boolean over;
    private QuestionDTO currentQuestion;
    private int progress;
    private int total;
}
