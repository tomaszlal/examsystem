package ma.cu.lalewicz.examsystem.controller;

import ma.cu.lalewicz.examsystem.entity.TestExam;
import ma.cu.lalewicz.examsystem.service.TestExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestExamController {

    @Autowired
    private TestExamService testExamService;

    @GetMapping("/testexams")
    public List<TestExam> getAllTestExams(){
        return testExamService.getAllTestExam();
    }

    @GetMapping("/testexam/{id}")
    public TestExam getTestExam(@PathVariable Long id){
        return testExamService.getTestExamById(id);
    }

    @GetMapping("/testexam/null/{id}")
    public void insertNullAnswers(@PathVariable Long id){
        testExamService.insertNullAnswers(id);
    }
}
