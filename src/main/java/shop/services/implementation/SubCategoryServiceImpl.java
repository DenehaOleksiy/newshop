package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import shop.entity.SubCategory;
import shop.repo.SubCategoryRepo;
import shop.services.SubCategoryService;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepo subCategoryRepo;


    public List<SubCategory> showAll() {
        return subCategoryRepo.findAll();
    }

    @Override
    public SubCategory findOne(int id) {
        return subCategoryRepo.findOne(id);
    }

    @Override
    public void addSubCategory(String name) {
        SubCategory subCategory = new SubCategory();
        subCategory.setName(name);
        subCategoryRepo.save(subCategory);
    }

    @Override
    public void delete(int id) {
        SubCategory subCategory = subCategoryRepo.findOne(id);
        subCategoryRepo.delete(subCategory);

    }
}
