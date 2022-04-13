package ru.hrumi.hw_311.DAO;
import org.springframework.stereotype.Component;
import ru.hrumi.hw_311.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public List<User> getAllUsers() { //зачем-то подчеркивает User
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User updateUser = getUserById(id);
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

}


