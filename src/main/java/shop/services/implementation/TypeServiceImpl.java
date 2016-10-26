package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import shop.entity.Type;
import shop.repo.TypeRepo;
import shop.services.TypeService;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepo typeRepo;


    public List<Type> showAll() {
        return typeRepo.findAll();
    }

    @Override
    public Type findOne(int id) {
        return typeRepo.findOne(id);
    }

    @Override
    public void addType(String name) {
        Type type = new Type();
        type.setName(name);
        typeRepo.save(type);
    }

    @Override
    public void delete(int id) {
        Type type = typeRepo.findOne(id);
        typeRepo.delete(type);

    }
}
