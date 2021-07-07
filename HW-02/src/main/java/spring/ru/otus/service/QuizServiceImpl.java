package spring.ru.otus.service;

import org.springframework.stereotype.Service;
import spring.ru.otus.dao.DataConnector;
import spring.ru.otus.domain.Question;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuizServiceImpl implements QuizService {
    private final DataConnector dao;

    public QuizServiceImpl(DataConnector dao) {
        this.dao = dao;
    }

    Scanner scanner = new Scanner(System.in);

    public void startQuiz() {
        AtomicInteger scope = new AtomicInteger();
        List<Question> questions = dao.findQuestions();
        questions.forEach(question -> {
            System.out.println(question);
            System.out.println("Please, input number of correct answer");
            int userAnswer = scanner.nextInt();
            if (question.getAnswers().get(userAnswer).getId() == question.getCorrectAnswerId()) {
                scope.getAndIncrement();
            }
        });
        System.out.println("Scope: " + scope);
    }
}
