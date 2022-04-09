package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.TestExam;
import ma.cu.lalewicz.examsystem.repository.TestExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
