package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.Answer;
import ma.cu.lalewicz.examsystem.entity.TestExam;
import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.repository.TestExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestExamService {

    @Autowired
    private TestExamDao testExamDao;

    public TestExam addNewTestExam(TestExam testExam){
        return testExamDao.save(testExam);
    }

    public List<TestExam> getAllTestExam(){
        return (List<TestExam>) testExamDao.findAll();
    }

    public TestExam getTestExamById(Long id) {
        return testExamDao.findById(id).get();
    }

    public TestExam updateTestExam(TestExam testExam){
        return testExamDao.save(testExam);
    }


    public void insertNullAnswers(Long testExamId){
        TestExam testExam = testExamDao.findById(testExamId).get();
        List<TestQuestion> questionList = testExam.getSetOfQuestion().getQuestionList();
        List<Answer> answerArrayList = new ArrayList<>();
        for (int i=0;i<questionList.size();i++) {
            answerArrayList.add(new Answer(null));
        }
        testExam.setAnswers(answerArrayList);
        updateTestExam(testExam);
    }
}
