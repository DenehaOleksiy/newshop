package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.entity.Goods;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface GoodsRepo extends JpaRepository<Goods,Integer> {

    @Query("SELECT g from Goods g where g.category.name like:name")
    List<Goods> byCategory(@Param("name") String categoryName);


    @Query("SELECT g from Goods g where g.brand.name like:name")
    List<Goods> byBrand(@Param("name") String brandName);
}
