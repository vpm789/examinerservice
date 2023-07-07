package pro.sky.java.course2.examinerservice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }
    @PostConstruct
    public void init() {
        questions.add(new Question("javaQuestion1", "javaAnswer1"));
        questions.add(new Question("javaQuestion2", "javaAnswer2"));
        questions.add(new Question("javaQuestion3", "javaAnswer3"));
        questions.add(new Question("javaQuestion4", "javaAnswer4"));
        questions.add(new Question("javaQuestion5", "javaAnswer5"));
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }
}
