package ma.cu.lalewicz.examsystem.repository;

import ma.cu.lalewicz.examsystem.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
}
