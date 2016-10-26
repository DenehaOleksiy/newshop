package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.Brand;
import shop.repo.BrandRepo;
import shop.services.BrandService;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepo;

    public List<Brand> findAll() {
        return brandRepo.findAll();
    }


    public Brand findOne(int id) {
        return brandRepo.findOne(id);
    }


    public void addBrand(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        brandRepo.save(brand);
    }


    public void delete(int id) {
        Brand brand = brandRepo.findOne(id);
        brandRepo.delete(brand);

    }
}