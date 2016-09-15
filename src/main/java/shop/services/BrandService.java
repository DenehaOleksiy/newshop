package shop.services;

import shop.entity.Brand;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface BrandService {

    List<Brand> findAll();
    Brand findOne(int id);

    void addBrand(String name);
    void delete(int id);
}
