package spring.ru.otus.domain;

public class Answer {
    private final int id;
    private final int question_id;
    private final String text;

    public Answer(int id, int question_id, String text) {
        this.id = id;
        this.question_id = question_id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
