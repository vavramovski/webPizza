package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Service;

public interface OrderRepository {
     Order getOrder(long ID);

     Order placeOrder(long ID,Order order);

     Long generateID();
}
