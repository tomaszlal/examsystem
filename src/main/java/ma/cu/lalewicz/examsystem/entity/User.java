package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TestExam> testExams;

    public User() {
    }

    public User(String name, String password, List<TestExam> testExams) {
        this.name = name;
        this.password = password;
        this.testExams = testExams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TestExam> getTestExams() {
        return testExams;
    }

    public void setTestExams(List<TestExam> testExams) {
        this.testExams = testExams;
    }
}
