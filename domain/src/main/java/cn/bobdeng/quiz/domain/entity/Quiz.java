package cn.bobdeng.quiz.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {
    private String id;
    private List<Question> questions;
    private int progress;
    private long startTime;

    public int getScore() {
        return (int) questions.stream()
                .filter(Question::isRightAnswer)
                .count();
    }

    public Question getCurrentQuestion() {
        return questions.get(progress);
    }

    public void submitAnswerAndGoNext(int selected, QuestionInBank questionInBank) {
        Question question = getCurrentQuestion();
        question.setAnswer(selected);
        question.setRightAnswer(question.getAnswer() == questionInBank.getRightAnswer());
        setProgress(progress + 1);
    }

    public boolean hasNext() {
        return getProgress() < getQuestions().size();
    }

    public static Quiz of(List<Question> questions) {
        Quiz quiz = new Quiz();
        quiz.setId(UUID.randomUUID().toString());
        quiz.setProgress(0);
        quiz.setStartTime(System.currentTimeMillis());
        quiz.setQuestions(questions);
        return quiz;
    }

    public boolean isOver() {
        return !hasNext();
    }
}
