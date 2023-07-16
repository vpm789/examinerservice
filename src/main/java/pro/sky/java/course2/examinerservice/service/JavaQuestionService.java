package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import java.util.*;

@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    Random random = new Random();

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }


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
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Object[] arrQuestion = javaQuestionRepository.getAll().toArray();
        int randomIndex = random.nextInt(arrQuestion.length);
        return (Question) arrQuestion[randomIndex];
    }
}
