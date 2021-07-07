package spring.ru.otus.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private final int id;
    private final String text;
    private final List<Answer> answers;

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
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

    @Override
    public String toString() {
        return "Question: " +
                text + "\n" +
                "   answers:" + "\n     " +
                answers.stream()
                        .map(Answer::getText)
                .collect(Collectors.joining("\n     "));
    }
}
