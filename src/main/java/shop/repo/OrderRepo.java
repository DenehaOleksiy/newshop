package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Order;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
