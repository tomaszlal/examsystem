package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.repository.TestQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestQuestionService {


    @Autowired
    private TestQuestionDao testQuestionDao;

    public TestQuestion addTestQuestion(TestQuestion testQuestion) {
        return testQuestionDao.save(testQuestion);
    }

    public List<TestQuestion> getAllTestQuestion() {
        return (List<TestQuestion>) testQuestionDao.findAll();
    }

    public TestQuestion addCategoryToTestQuestion(Long idTestQuestion, Category category){
        TestQuestion question = testQuestionDao.findById(idTestQuestion).get();
        List<Category> categoryList = question.getCategoryList();
        categoryList.add(category);
        return testQuestionDao.save(question);
    }

}
