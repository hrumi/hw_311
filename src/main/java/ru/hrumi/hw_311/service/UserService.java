package ru.hrumi.hw_311.service;

import ru.hrumi.hw_311.model.User;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void updateUser(int id, User user);
    public void deleteUser(int id);
    public void addUser(User user);
}
