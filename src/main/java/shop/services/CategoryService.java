package shop.services;


import shop.entity.Type;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface CategoryService {

    List<Type> showAll();
    Type findOne(int id);
    void addCategory(String name);
    void delete(int id);
}
