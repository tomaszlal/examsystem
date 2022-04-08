package ma.cu.lalewicz.examsystem.service;

import ma.cu.lalewicz.examsystem.entity.User;
import ma.cu.lalewicz.examsystem.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User addNewUser(User user){
        return userDao.save(user);
    }
}
