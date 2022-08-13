package pro.sky.coursework.service.examiner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework.domain.Question;
import pro.sky.coursework.exceptions.AmountOutOfSizeException;
import pro.sky.coursework.service.question.JavaQuestionService;
import pro.sky.coursework.service.question.MathQuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    private final MathQuestionService questionService2;

    List<Question> questionsJava;
    List<Question> questionsMath;
    List<Question> publicList;

    public ExaminerServiceImpl(JavaQuestionService questionService, MathQuestionService questionService2) {
        this.questionService = questionService;
        this.questionService2 = questionService2;
    }

    @Override
    public Collection<Question> getQuestions(int amountJava, int amountMath) {
        questionsJava = new ArrayList<>();
        questionsMath = new ArrayList<>();

        if (amountJava > questionService.getAll().size()) {
            throw new AmountOutOfSizeException("Amount out of questions list bound");
        } else {
            int i = 0;
            while (i < amountJava) {
                questionsJava.add(questionService.getRandomQuestion());
                i++;
            }
        }

        if (amountMath > questionService2.getAll().size()) {
            throw new AmountOutOfSizeException("Amount out of questions list bound");
        } else {
            int i = 0;
            while (i < amountMath) {
                questionsMath.add(questionService2.getRandomQuestion());
                i++;
            }
        }
        publicList = new ArrayList<>();
        publicList.addAll(questionsJava);
        publicList.addAll(questionsMath);
        return publicList;
    }
}
