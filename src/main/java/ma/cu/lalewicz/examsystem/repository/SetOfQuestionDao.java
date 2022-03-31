package ma.cu.lalewicz.examsystem.repository;

import ma.cu.lalewicz.examsystem.entity.SetOfQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetOfQuestionDao extends CrudRepository<SetOfQuestion, Long> {
}
