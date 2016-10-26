package shop.services;


import shop.entity.Type;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface TypeService {

    List<Type> showAll();
    Type findOne(int id);
    void addType(String name);
    void delete(int id);
}
