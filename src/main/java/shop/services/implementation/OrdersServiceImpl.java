package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.Orders;
import shop.repo.OrdersRepo;
import shop.services.OrdersService;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepo orderRepo;


    public void add(Orders order) {

        orderRepo.save(order);
    }
}
