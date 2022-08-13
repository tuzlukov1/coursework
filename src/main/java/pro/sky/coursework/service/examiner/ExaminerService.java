package pro.sky.coursework.service.examiner;

import pro.sky.coursework.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amountJava, int amountMath);
}
