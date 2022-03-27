package ma.cu.lalewicz.examsystem.repository;

import ma.cu.lalewicz.examsystem.entity.TestQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestQuestionDao extends CrudRepository<TestQuestion,Long> {
}
