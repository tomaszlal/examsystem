package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.repository.CategoryDao;
import ma.cu.lalewicz.examsystem.repository.TestQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private TestQuestionDao testQuestionDao;

    public Category addNewCategory(Category category) {
        return categoryDao.save(category);
    }

    public List<Category> getAllCategory() {
        return (List<Category>) categoryDao.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryDao.findById(id).get();
    }

    public Category updateCategory(Category category) {
        return categoryDao.save(category);
    }

    public void deleteCategory(Long id) {

        //usuniecie z pytań testowych usuwanej kategorii..
        Iterable<TestQuestion> testQuestions = testQuestionDao.findAll();
        List<TestQuestion> newTestQuestions = new ArrayList<>();
        for (TestQuestion question : testQuestions) {
            List<Category> categoryList = question.getCategoryList();
            List<Category> newCategoryList = new ArrayList<>();
            for (Category category : categoryList) {
                if (category.getId() != id) {
                    newCategoryList.add(category);
                }
            }
            question.setCategoryList(newCategoryList);
            newTestQuestions.add(question);
        }
        testQuestionDao.saveAll(newTestQuestions);


        //usuniecie kategorii
        categoryDao.deleteById(id);
    }
}
