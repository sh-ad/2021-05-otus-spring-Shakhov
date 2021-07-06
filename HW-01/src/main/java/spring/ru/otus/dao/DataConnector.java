package spring.ru.otus.dao;

import spring.ru.otus.domain.Answer;
import spring.ru.otus.domain.Question;

import java.util.List;

public interface DataConnector {

    List<Question> findQuestions();

    List<Answer> getAnswers(int question_id);
}
