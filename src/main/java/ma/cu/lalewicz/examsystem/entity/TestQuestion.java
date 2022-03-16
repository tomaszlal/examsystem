package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "test_question")
public class TestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question_content",nullable = false)
    private String questionContent;
    @Column(name = "answer_a")
    private String answerA;
    @Column(name = "answer_b")
    private String answerB;
    @Column(name = "answer_c")
    private String answerC;
    @Column(name = "answer_d")
    private String answerD;
    @Column(name = "correct_answer")
    private Character correctAnswer;
    @Column(name = "url_image")
    private String urlImage;
    @Column(nullable = false)
    private Integer score;

    @ManyToMany
    private List<Category> categoryList;






}
