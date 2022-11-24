package web.Dao;

import org.hibernate.sql.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("select us from User us").getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        User user = entityManager.find(User.class,id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }
}
