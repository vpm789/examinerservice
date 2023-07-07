package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{
    Random random = new Random();
    public final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        if (question != null && answer != null) {
            return add(new Question(question, answer));
        } else {
            return null;
        }
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Object[] arrQuestion = mathQuestionRepository.getAll().toArray();
        int randomIndex = random.nextInt(arrQuestion.length);
        return (Question) arrQuestion[randomIndex];
    }
}
