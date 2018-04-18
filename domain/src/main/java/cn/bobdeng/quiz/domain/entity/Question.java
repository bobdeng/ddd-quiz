package cn.bobdeng.quiz.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Question {
    private String questionId;
    private int answer;
    private boolean rightAnswer;

    public static Question init(String id) {
        return Question.builder()
                .answer(-1)
                .questionId(id)
                .rightAnswer(false)
                .build();
    }
}
