package pro.sky.coursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework.domain.Question;
import pro.sky.coursework.service.question.MathQuestionService;
import pro.sky.coursework.service.question.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") MathQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return service.add(question,answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        return service.remove(question1);
    }

    @GetMapping("")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

}
