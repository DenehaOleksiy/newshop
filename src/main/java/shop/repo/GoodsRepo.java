package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.Product;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface GoodsRepo extends JpaRepository<Product,Integer> {

    @Query("SELECT g from Product g where g.category.name like:name")
    List<Product> byCategory(@Param("name") String categoryName);


    @Query("SELECT g from Product g where g.brand.name like:name")
    List<Product> byBrand(@Param("name") String brandName);
}
