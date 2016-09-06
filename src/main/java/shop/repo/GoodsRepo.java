package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Goods;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface GoodsRepo extends JpaRepository<Goods,Integer> {
}
