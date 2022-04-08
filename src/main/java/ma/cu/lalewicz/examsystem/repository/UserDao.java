package ma.cu.lalewicz.examsystem.repository;

import ma.cu.lalewicz.examsystem.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
}
