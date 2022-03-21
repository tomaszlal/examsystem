package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answered;

    public Answer() {
    }

    public Answer(String answered) {
        this.answered = answered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswered() {
        return answered;
    }

    public void setAnswered(String answered) {
        this.answered = answered;
    }
}
