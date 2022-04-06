package ma.cu.lalewicz.examsystem.controller;

import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestQuestionController {

    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping("/questions")
    public List<TestQuestion> getAllQuestion() {
        return testQuestionService.getAllTestQuestion();
    }

    @GetMapping("/question/{id}")
    public TestQuestion getQuestion(@PathVariable("id") Long id) {
        return testQuestionService.getTestQuestion(id);
    }

    @PostMapping("/question")
    public TestQuestion addQuestion(@RequestBody TestQuestion testQuestion) {
        return testQuestionService.addTestQuestion(testQuestion);
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable Long id){
        testQuestionService.deleteTestQuestion(id);
    }

    @PutMapping("/question")
    public TestQuestion updateTestQuestion(@RequestBody TestQuestion testQuestion){
        return testQuestionService.updateTestQuestion(testQuestion);
    }

}
