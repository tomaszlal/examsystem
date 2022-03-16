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


}
