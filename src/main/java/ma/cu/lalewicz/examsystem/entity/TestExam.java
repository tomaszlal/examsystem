package ma.cu.lalewicz.examsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ma.cu.lalewicz.examsystem.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TestExam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private User user;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private SetOfQuestion setOfQuestion;

    @ManyToMany
    private List<Answer> answers;

    @Enumerated
    private Status status;

    private Integer points;
    private Integer maxPoints;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    public TestExam() {
    }

    public TestExam(User user, SetOfQuestion setOfQuestion, Status status, Integer maxPoints, LocalDate startDate) {
        this.user = user;
        this.setOfQuestion = setOfQuestion;
        this.status = status;
        this.maxPoints = maxPoints;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SetOfQuestion getSetOfQuestion() {
        return setOfQuestion;
    }

    public void setSetOfQuestion(SetOfQuestion setOfQuestion) {
        this.setOfQuestion = setOfQuestion;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


}
