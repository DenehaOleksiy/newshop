package shop.services;

import shop.entity.User;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface UserService {

    void add(User user);

    List<User> showAll();

    User findOne(int id);
}
