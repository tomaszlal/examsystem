package ma.cu.lalewicz.examsystem.controller;


import ma.cu.lalewicz.examsystem.entity.Category;
import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import ma.cu.lalewicz.examsystem.service.CategoryService;
import ma.cu.lalewicz.examsystem.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TestQuestionService testQuestionService;

    @PostConstruct
    public void createSampleData(){
        //create category

        categoryService.addNewCategory(new Category("INF.02","Pytania z zakresu kwalifikacji INF.02"));
        categoryService.addNewCategory(new Category("INF.03","Pytania z zakresu kwalifikacji INF.03"));
        categoryService.addNewCategory(new Category("HTML","Pytania ze znajomośi HTML"));
        categoryService.addNewCategory(new Category("C++","Pytania z języka programowania C++"));

        //create testquestion


        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setQuestionContent("Co to jest boolean ?");
        testQuestion.setAnswerA("Dana z programu");
        testQuestion.setAnswerB("Polecenie systemu operacyjnego");
        testQuestion.setAnswerC("typ zmiennej w języku C++");
        testQuestion.setAnswerD("rodzaj plików zaszyfrowanych");
        testQuestion.setCorrectAnswer('C');
        testQuestion.setScore(1);
        List<Category> categories = new ArrayList<>();
        categories.add(categoryService.getCategoryById(2l));
        categories.add(categoryService.getCategoryById(4l));
        testQuestion.setCategoryList(categories);
        testQuestionService.addTestQuestion(testQuestion);

        //create 2 testquestion
        TestQuestion testQuestion2 = new TestQuestion();
        testQuestion2.setQuestionContent("Zmienna to");
        testQuestion2.setAnswerA("Miejsce w pamieci");
        testQuestion2.setAnswerB("Zmieniajaca kierunek chorągiewka");
        testQuestion2.setAnswerC("Taka szufladka");
        testQuestion2.setAnswerD("rodzaj plików zaszyfrowanych");
        testQuestion2.setCorrectAnswer('A');
        testQuestion2.setScore(2);
        List<Category> categories2 = new ArrayList<>();
        categories2.add(categoryService.getCategoryById(1l));
        categories2.add(categoryService.getCategoryById(4l));
        testQuestion2.setCategoryList(categories2);
        testQuestionService.addTestQuestion(testQuestion2);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello I am a conttoller";
    }




}
