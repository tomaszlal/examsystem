package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.SetOfQuestion;
import ma.cu.lalewicz.examsystem.repository.SetOfQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetOfQuestionService {

    @Autowired
    private SetOfQuestionDao setOfQuestionDao;

    public SetOfQuestion addNewSetOfQuestion(SetOfQuestion setOfQuestion) {
        return setOfQuestionDao.save(setOfQuestion);
    }

    public List<SetOfQuestion> getAllSetOfQuestion(){
        return (List<SetOfQuestion>) setOfQuestionDao.findAll();
    }
}
