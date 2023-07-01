package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question != null && answer != null) {
            Question newQuestion = new Question(question, answer);
            return add(newQuestion);
        } else {
            return null;
        }
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

    @Override
    public Question getRandomQuestion() {
        Object[] arrQuestion = questions.toArray();
        int randomIndex = random.nextInt(arrQuestion.length);
        return (Question) arrQuestion[randomIndex];
    }
}
