package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.repository.TestQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public TestQuestion deleteCategoryFromTestQuestion(Long idTestQuestion, Long idCategory){
        TestQuestion question = testQuestionDao.findById(idTestQuestion).get();
        List<Category> categoryList = question.getCategoryList();
        List<Category> newCategoryList = new ArrayList<>();
        for (Category category : categoryList){
            if(!category.getId().equals(idCategory)){
                newCategoryList.add(category);
            }
        }
        question.setCategoryList(newCategoryList);
        return testQuestionDao.save(question);
    }


    public TestQuestion getTestQuestion(Long idTestQuestion){
        return testQuestionDao.findById(idTestQuestion).get();
    }

    public void deleteTestQuestion(Long id){
        //usuniecie z seta pytania albo jezeli jest w secie to nie usuwanie do zastanowienia
        testQuestionDao.deleteById(id);
    }

    public TestQuestion updateTestQuestion(TestQuestion testQuestion){
        return testQuestionDao.save(testQuestion);
    }


}
