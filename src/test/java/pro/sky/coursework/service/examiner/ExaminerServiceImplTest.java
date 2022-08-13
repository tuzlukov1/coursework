package pro.sky.coursework.service.examiner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework.domain.Question;
import pro.sky.coursework.service.question.JavaQuestionService;
import pro.sky.coursework.service.question.MathQuestionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @Mock
    MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Question javaQuestion1 = new Question("JavaQuestion1", "JavaAnswer1");
        Question javaQuestion2 = new Question("JavaQuestion2", "JavaAnswer2");
        Question javaQuestion3 = new Question("JavaQuestion3", "JavaAnswer3");
        Question javaQuestion4 = new Question("JavaQuestion4", "JavaAnswer4");
        List<Question> javaQuestions = new ArrayList<>(List.of(javaQuestion1, javaQuestion2, javaQuestion3, javaQuestion4));

        Question mathQuestion1 = new Question("MathQuestion1", "MathAnswer1");
        Question mathQuestion2 = new Question("MathQuestion2", "MathAnswer2");
        Question mathQuestion3 = new Question("MathQuestion3", "MathAnswer3");
        Question mathQuestion4 = new Question("MathQuestion4", "MathAnswer4");
        List<Question> mathQuestions = new ArrayList<>(List.of(mathQuestion1, mathQuestion2, mathQuestion3, mathQuestion4));

        Mockito.when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        Mockito.when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(javaQuestion2, javaQuestion3, javaQuestion4);
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(mathQuestion2, mathQuestion3, mathQuestion4, mathQuestion1);

        List list = new ArrayList(examinerService.getQuestions(3,4));
        List list1 = new ArrayList(List.of(javaQuestion2, javaQuestion3, javaQuestion4, mathQuestion2, mathQuestion3, mathQuestion4, mathQuestion1));
        assertEquals(list, list1);
    }
}
