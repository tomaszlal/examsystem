package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String passwd;

    @OneToMany(mappedBy = "user")
    private List<TestExam> testExams;

}
