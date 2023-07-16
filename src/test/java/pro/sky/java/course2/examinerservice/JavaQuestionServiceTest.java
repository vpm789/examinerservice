package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService out;


    @Test
    public void addTest() {
        Question question = new Question("javaQuestion1", "javaAnswer1");
        when(javaQuestionRepository.add(any())).thenReturn(question);
        var actual = out.add("javaQuestion1", "javaAnswer1");
        assertEquals(question, actual);
    }

    @Test
    public void testDelete() {
        Question question = new Question("javaQuestion1", "javaAnswer1");
        when(javaQuestionRepository.remove(any())).thenReturn(question);
        var actual = out.remove(question);
        assertEquals(question, actual);
    }

}
