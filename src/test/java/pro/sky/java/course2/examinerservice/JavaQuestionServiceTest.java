package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService(new JavaQuestionRepository());
    @Test
    public void shouldReturnErrorWhenAddIsIncorrect() {
        out.add("question1", "answer1");
        assertTrue(out.getAll().contains(new Question("question1", "answer1")));
    }
    @Test
    public void shouldReturnErrorWhenDeleteIsIncorrect() {
        out.add("question1", "answer1");
        out.remove(new Question("question1", "answer1"));
        assertTrue(out.getAll().isEmpty());
    }

}
