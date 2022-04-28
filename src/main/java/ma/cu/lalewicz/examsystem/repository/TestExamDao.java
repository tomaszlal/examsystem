package ma.cu.lalewicz.examsystem.repository;

import ma.cu.lalewicz.examsystem.entity.TestExam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestExamDao extends CrudRepository<TestExam,Long> {



}
