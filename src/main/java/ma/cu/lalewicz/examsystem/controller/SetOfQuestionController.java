package ma.cu.lalewicz.examsystem.controller;

import ma.cu.lalewicz.examsystem.entity.SetOfQuestion;
import ma.cu.lalewicz.examsystem.service.SetOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SetOfQuestionController {

    @Autowired
    private SetOfQuestionService setOfQuestionService;

    @GetMapping("/setofquestions")
    public List<SetOfQuestion> getAllSetOfQestion(){
        return setOfQuestionService.getAllSetOfQuestion();
    }

    @GetMapping("/setofquestion/{id}")
    public SetOfQuestion getSetOfQuestion(@PathVariable Long id){
        return setOfQuestionService.getSetOfQuestionById(id);
    }

    @PostMapping("setofquestion")
    public SetOfQuestion addNewSetOfQuestion(@RequestBody SetOfQuestion setOfQuestion){
        return setOfQuestionService.addNewSetOfQuestion(setOfQuestion);
    }

    @PutMapping("setofquestion")
    public SetOfQuestion updateSetOfQuestion(@RequestBody SetOfQuestion setOfQuestion){
        return setOfQuestionService.updateSetOfQuestion(setOfQuestion);
    }
}
