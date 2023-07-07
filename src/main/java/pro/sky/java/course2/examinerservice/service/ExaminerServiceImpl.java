package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exception.NotEnoughQuestionException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService javaQuestionService;
    private QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount || mathQuestionService.getAll().size() < amount) {
            throw new NotEnoughQuestionException();
        }
        List<Question> questions = new ArrayList<>();
        while (questions.size() < amount) {
            Question question = new Random().nextBoolean() ?
                    javaQuestionService.getRandomQuestion() :
                    mathQuestionService.getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }
}
