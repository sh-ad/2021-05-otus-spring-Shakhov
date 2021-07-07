package spring.ru.otus.domain;

import java.util.List;

public class Question {
    private final int id;
    private final String text;
    private final List<Answer> answers;
    private final int correctAnswerId;

    public Question(int id, String text, List<Answer> answers, int correctAnswerId) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.correctAnswerId = correctAnswerId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Question: " +
                text + "\n" +
                "Answers:");
        for (int i = 0; i< answers.size(); i++){
            stringBuilder.append("      \n")
                    .append(i)
                    .append(":")
                    .append(answers.get(i).getText());
        }
        return stringBuilder.toString();
    }

}
