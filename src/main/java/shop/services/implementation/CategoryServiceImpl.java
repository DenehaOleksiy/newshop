package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import shop.entity.Type;
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


    public List<Type> showAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Type findOne(int id) {
        return categoryRepo.findOne(id);
    }

    @Override
    public void addCategory(String name) {
        Type type = new Type();
        type.setName(name);
        categoryRepo.save(type);
    }

    @Override
    public void delete(int id) {
        Type type = categoryRepo.findOne(id);
        categoryRepo.delete(type);

    }
    
}
