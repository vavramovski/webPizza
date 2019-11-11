package mk.ukim.finki.wp.lab.repository.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;

@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    static Random randomGenerator = new Random();

    private HashMap<Long, Order>orders;

    public Order getOrder(long ID) {
        return orders.get(ID);
    }

    public Order placeOrder(long ID,Order order) {
        return orders.put(ID,order);

    }

    @Override
    public Long generateID() {
        return (long)randomGenerator.nextInt(500);
    }

}
