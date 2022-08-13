package pro.sky.coursework.service.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import pro.sky.coursework.domain.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    QuestionService service = new JavaQuestionService();

    Question question1 = new Question("JavaQuestion1", "JavaAnswer1");
    Question question2 = new Question("JavaQuestion2", "JavaAnswer2");
    Question question3 = new Question("JavaQuestion3", "JavaAnswer3");
    Set<Question> questions = new HashSet<>(List.of(question1, question2, question3));

    @Test
    void add() {
        Question question = new Question("Question!#@", "Answer!#@");
        service.add(question);
        Assertions.assertTrue(service.getAll().contains(question));
    }

    @Test
    void remove() {
        Question question = new Question("Question!#@", "Answer!#@");
        service.add(question);
        service.remove(question);
        Assertions.assertFalse(service.getAll().contains(question));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(service.getAll(), questions);
    }

    @Test
    void getRandomQuestion() {
        Question question = service.getRandomQuestion();
        Assertions.assertTrue(service.getAll().contains(question));
    }
}