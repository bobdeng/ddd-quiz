package cn.bobdeng.quiz.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionInBank {
    private String id;
    private String question;
    private String[] options;
    private int rightAnswer;
    private String[] tag;
}
