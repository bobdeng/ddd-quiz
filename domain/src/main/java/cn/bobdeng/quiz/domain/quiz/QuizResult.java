package cn.bobdeng.quiz.domain.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizResult {
    private String id;
    private int score;
    private int rank;
}
