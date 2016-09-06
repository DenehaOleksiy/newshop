package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Orders;

/**
 * Created by Администратор on 05.09.2016.
 */
public interface OrdersRepo extends JpaRepository<Orders,Integer> {
}
