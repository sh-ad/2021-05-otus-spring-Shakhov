package spring.ru.otus.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import spring.ru.otus.domain.Answer;
import spring.ru.otus.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DataConnectorImpl implements DataConnector {
    private static String SPLITTER = ";";
    private String questionFileName;
    private String answerFileName;

    @Override
    public List<Question> findQuestions() {
        List<Question> questions = new ArrayList<>();
        Resource resource = new ClassPathResource(questionFileName);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            String csv = FileCopyUtils.copyToString(reader);
            for (String questionLine : csv.split(System.getProperty("line.separator"))) {
                questions.add(stringToQuestion(questionLine));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return questions;
    }

    private Question stringToQuestion(String line) {
        String[] fields = line.split(SPLITTER);
        return new Question(Integer.parseInt(fields[0]), fields[1], Collections.emptyList());
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    public void setQuestionFileName(String questionFileName) {
        this.questionFileName = questionFileName;
    }

    public void setAnswerFileName(String answerFileName) {
        this.answerFileName = answerFileName;
    }
}
