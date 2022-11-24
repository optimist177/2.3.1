package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao UserDao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.UserDao = dao;
    }
    @Override
    public List<User> getAllUsers() {
        return UserDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return UserDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        UserDao.saveUser(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        UserDao.updateUser(id,updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        UserDao.deleteUser(id);
    }
}
