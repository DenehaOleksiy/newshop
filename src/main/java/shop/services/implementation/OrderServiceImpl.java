package shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.Order;
import shop.repo.OrderRepo;
import shop.services.OrderService;

/**
 * Created by Администратор on 05.09.2016.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderRepo;


    public void add(Order order) {

        orderRepo.save(order);
    }
}