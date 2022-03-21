package ma.cu.lalewicz.examsystem.controller;


import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CategoryService categoryService;

    @PostConstruct
    public void createSampleData(){
        categoryService.addNewCategory(new Category("INF.02","Pytania z zakresu kwalifikacji INF.02"));
        categoryService.addNewCategory(new Category("INF.03","Pytania z zakresu kwalifikacji INF.03"));
        categoryService.addNewCategory(new Category("HTML","Pytania ze znajomośi HTML"));
        categoryService.addNewCategory(new Category("C++","Pytania z języka programowania C++"));



    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello I am a conttoller";
    }

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addNewCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

}
