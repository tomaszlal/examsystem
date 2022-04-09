package ma.cu.lalewicz.examsystem.controller;


import ma.cu.lalewicz.examsystem.entity.*;
import ma.cu.lalewicz.examsystem.enums.Status;
import ma.cu.lalewicz.examsystem.service.*;
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
    @Autowired
    private SetOfQuestionService setOfQuestionService;
    @Autowired
    private UserService userService;
    @Autowired
    private TestExamService testExamService;

    @PostConstruct
    public void createSampleData(){
        //create category

        categoryService.addNewCategory(new Category("INF.02","Pytania z zakresu kwalifikacji INF.02"));
        categoryService.addNewCategory(new Category("INF.03","Pytania z zakresu kwalifikacji INF.03"));
        categoryService.addNewCategory(new Category("HTML","Pytania ze znajomośi HTML"));
        categoryService.addNewCategory(new Category("C++","Pytania z języka programowania C++"));
        categoryService.addNewCategory(new Category("Java","Pytania z języka programowania Java"));

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

        //create 3 testquestion
        TestQuestion testQuestion3 = new TestQuestion();
        testQuestion3.setQuestionContent("Pytanie testowe 3");
        testQuestion3.setAnswerA("Odp A pytanie 3");
        testQuestion3.setAnswerB("Odp B pytanie 3");
        testQuestion3.setAnswerC("Odp C pytanie 3");
        testQuestion3.setAnswerD("Odp D pytanie 3");
        testQuestion3.setCorrectAnswer('A');
        testQuestion3.setScore(2);
        List<Category> categories3 = new ArrayList<>();
        categories3.add(categoryService.getCategoryById(2l));
        categories3.add(categoryService.getCategoryById(3l));
        testQuestion3.setCategoryList(categories3);
        testQuestionService.addTestQuestion(testQuestion3);

        //create 4 testquestion
        TestQuestion testQuestion4 = new TestQuestion();
        testQuestion4.setQuestionContent("Pytanie testowe 4");
        testQuestion4.setAnswerA("Odp A pytanie 4");
        testQuestion4.setAnswerB("Odp B pytanie 4");
        testQuestion4.setAnswerC("Odp C pytanie 4");
        testQuestion4.setAnswerD("Odp D pytanie 4");
        testQuestion4.setCorrectAnswer('D');
        testQuestion4.setScore(3);
        List<Category> categories4 = new ArrayList<>();
        categories4.add(categoryService.getCategoryById(2l));
        categories4.add(categoryService.getCategoryById(1l));
        categories4.add(categoryService.getCategoryById(4l));
        testQuestion4.setCategoryList(categories4);
        testQuestionService.addTestQuestion(testQuestion4);


        //create set of question
        List<TestQuestion> testQuestionList = new ArrayList<>();
        testQuestionList.add(testQuestion);
        testQuestionList.add(testQuestion3);
        SetOfQuestion setOfQuestion1 = new SetOfQuestion();
        setOfQuestion1.setQuestionList(testQuestionList);
        setOfQuestionService.addNewSetOfQuestion(setOfQuestion1);

        //add category to test question

        testQuestionService.addCategoryToTestQuestion(testQuestion.getId(), categoryService.getCategoryById(5l));

        //add user to db

        User user1 = new User();
        user1.setName("tomasz");
        user1.setPassword("12345");
        User user2 = new User();
        user2.setName("zenek");
        user2.setPassword("12345");
        userService.addNewUser(user1);
        userService.addNewUser(user2);

        //add test exam
        TestExam testExam = new TestExam();
        testExam.setSetOfQuestion(setOfQuestion1);
        testExam.setUser(user1);
        testExam.setStatus(Status.IN_PREPARATION);
        testExam.setMaxPoints(20);
        testExamService.addNewTestExam(testExam);

    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello I am a controller";
    }




}
