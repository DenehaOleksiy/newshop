package shop.services;

import shop.entity.User;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface UserService {

    void add(User user);
    void edit(User user);
    void remove(int id);
    User findOneById(int id);
    List<User> findAll();

    public void sendEmail(int id, String email, String userName, String password, String registrationVar);
}
