package ma.cu.lalewicz.examsystem.controller;

import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

}
