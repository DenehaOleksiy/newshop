package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.Product;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query("SELECT p from Product p where p.type.name like:typeName")
    List<Product> byType(@Param("typeName") String typeName);


    @Query("SELECT p from Product p where p.brand.name like:brandName")
    List<Product> byBrand(@Param("brandName") String brandName);
}
