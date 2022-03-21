package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "set_of_question")
public class SetOfQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<TestQuestion> questionList;

    @OneToMany(mappedBy = "setOfQuestion")
    private List<TestExam> testExams;

    public SetOfQuestion() {
    }

    public SetOfQuestion(List<TestQuestion> questionList, List<TestExam> testExams) {
        this.questionList = questionList;
        this.testExams = testExams;
    }

    public Long getId() {
        return id;
    }

    public List<TestQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<TestQuestion> questionList) {
        this.questionList = questionList;
    }

    public List<TestExam> getTestExams() {
        return testExams;
    }

    public void setTestExams(List<TestExam> testExams) {
        this.testExams = testExams;
    }
}
