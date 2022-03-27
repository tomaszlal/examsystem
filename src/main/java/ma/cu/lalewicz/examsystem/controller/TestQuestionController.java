package ma.cu.lalewicz.examsystem.controller;

import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestQuestionController {

    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping("/test-questions")
    public List<TestQuestion> getAllQuestion( ) {
        return testQuestionService.getAllTestQuestion();
    }
}
