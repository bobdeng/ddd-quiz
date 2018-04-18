package cn.bobdeng.server.controller.quiz.facade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private String question;
    private String[] options;
}
