package ru.hrumi.hw_311.service;

import org.springframework.stereotype.Service;
import ru.hrumi.hw_311.DAO.UserDAOImpl;
import ru.hrumi.hw_311.model.User;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDAOImpl userDAOImpl;

    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAOImpl.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAOImpl.getUserById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userDAOImpl.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDAOImpl.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        userDAOImpl.addUser(user);
    }
}
