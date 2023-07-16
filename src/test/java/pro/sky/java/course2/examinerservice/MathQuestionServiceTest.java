package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;
import pro.sky.java.course2.examinerservice.service.MathQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService out;


    @Test
    public void addTest() {
        Question question = new Question("mathQuestion1", "mathAnswer1");
        when(mathQuestionRepository.add(any())).thenReturn(question);
        var actual = out.add("mathQuestion1", "mathAnswer1");
        assertEquals(question, actual);
    }

    @Test
    public void testDelete() {
        Question question = new Question("mathQuestion1", "mathAnswer1");
        when(mathQuestionRepository.remove(any())).thenReturn(question);
        var actual = out.remove(question);
        assertEquals(question, actual);
    }
}
