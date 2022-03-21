package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public Category addNewCategory(Category category){
        return categoryDao.save(category);
    }

    public List<Category> getAllCategory(){
        return (List<Category>) categoryDao.findAll();
    }
}
