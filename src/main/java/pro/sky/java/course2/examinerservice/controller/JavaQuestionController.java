package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/java")
    public Collection<Question> getQuestion() {
        return service.getAll();
    }
    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}
