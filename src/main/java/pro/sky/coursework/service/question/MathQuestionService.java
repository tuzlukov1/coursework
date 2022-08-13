package pro.sky.coursework.service.question;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework.domain.Question;
import pro.sky.coursework.repository.MathQuestionRepository;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

    Random random = new Random();
    List<Question> questionsArrayList;

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        mathQuestionRepository.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        mathQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        questionsArrayList = new ArrayList<>(mathQuestionRepository.getAll());
        return questionsArrayList.get(random.nextInt(questionsArrayList.size()));
    }
}
