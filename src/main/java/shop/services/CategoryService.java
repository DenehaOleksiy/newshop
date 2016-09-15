package shop.services;


import shop.entity.Category;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface CategoryService {

    List<Category> showAll();
    Category findOne(int id);
    void addCategory(String name);
    void delete(int id);
}
