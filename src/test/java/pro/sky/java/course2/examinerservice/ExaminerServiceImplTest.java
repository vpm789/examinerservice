package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;
import pro.sky.java.course2.examinerservice.service.MathQuestionService;

import java.util.Set;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void shouldReturnErrorWhenGetIsIncorrect() {
        Question javaQuestion1 = new Question("javaQuestion1", "javaAnswer1");
        Question javaQuestion2 = new Question("javaQuestion2", "javaAnswer2");
        Question javaQuestion3 = new Question("javaQuestion3", "javaAnswer3");
        Question mathQuestion1 = new Question("mathQuestion1", "mathAnswer1");
        Question mathQuestion2 = new Question("mathQuestion2", "mathAnswer2");
        Question mathQuestion3 = new Question("mathQuestion3", "mathAnswer3");
        Mockito.when(javaQuestionServiceMock.getAll()).thenReturn(Set.of(javaQuestion1, javaQuestion2, javaQuestion3));
        Mockito.when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(javaQuestion1);
        Mockito.when(mathQuestionServiceMock.getAll()).thenReturn(Set.of(mathQuestion1, mathQuestion2, mathQuestion3));
        Mockito.when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(mathQuestion1);

        Assertions.assertEquals(1, out.getQuestions(1).size());
    }
}

