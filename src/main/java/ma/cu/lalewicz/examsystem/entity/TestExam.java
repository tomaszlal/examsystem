package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;

@Entity
public class TestExam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private SetOfQuestion setOfQuestion;


}
