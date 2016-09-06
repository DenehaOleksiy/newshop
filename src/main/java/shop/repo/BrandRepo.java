package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Brand;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface BrandRepo extends JpaRepository<Brand,Integer> {
}
