package shop.services;


import shop.entity.SubCategory;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface SubCategoryService {

    List<SubCategory> showAll();
    SubCategory findOne(int id);
    void addSubCategory(String name);
    void delete(int id);

}
