package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import shop.entity.Category;
import shop.repo.CategoryRepo;
import shop.services.CategoryService;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public List<Category> showAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findOne(int id) {
        return categoryRepo.findOne(id);
    }

    @Override
    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepo.findOne(id);
        categoryRepo.delete(category);

    }
    
}
