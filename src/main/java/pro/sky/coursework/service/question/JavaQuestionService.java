package pro.sky.coursework.service.question;

import org.springframework.stereotype.Service;
import pro.sky.coursework.domain.Question;
import pro.sky.coursework.repository.JavaQuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    Random random = new Random();
    List<Question> questionsArrayList;

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        javaQuestionRepository.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        questionsArrayList = new ArrayList<>(javaQuestionRepository.getAll());
        return questionsArrayList.get(random.nextInt(questionsArrayList.size()));
    }
}
