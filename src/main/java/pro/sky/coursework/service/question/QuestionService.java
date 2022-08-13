package pro.sky.coursework.service.question;

import pro.sky.coursework.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
