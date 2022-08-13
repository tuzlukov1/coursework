package pro.sky.coursework.repository;

import pro.sky.coursework.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaQuestionRepository implements QuestionRepository{

    public JavaQuestionRepository() {
    }

    Question question1 = new Question("JavaQuestion1", "JavaAnswer1");
    Question question2 = new Question("JavaQuestion2", "JavaAnswer2");
    Question question3 = new Question("JavaQuestion3", "JavaAnswer3");
    Set<Question> questions = new HashSet<>(List.of(question1, question2, question3));

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);
        questions.add(quest);
        return quest;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
