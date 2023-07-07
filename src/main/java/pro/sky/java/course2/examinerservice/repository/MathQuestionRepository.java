package pro.sky.java.course2.examinerservice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }
    @PostConstruct
    public void init() {
        questions.add(new Question("mathQuestion1", "mathAnswer1"));
        questions.add(new Question("mathQuestion2", "mathAnswer2"));
        questions.add(new Question("mathQuestion3", "mathAnswer3"));
        questions.add(new Question("mathQuestion4", "mathAnswer4"));
        questions.add(new Question("mathQuestion5", "mathAnswer5"));
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
