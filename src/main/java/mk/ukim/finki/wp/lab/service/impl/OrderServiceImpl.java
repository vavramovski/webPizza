package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.repository.OrderRepository;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String pizzaType, String clientName, String address) {
        long ID = orderRepository.generateID();
        Order newOrder = new Order(pizzaType,clientName,address,ID);
        orderRepository.placeOrder(ID,newOrder);
        return newOrder;
    }

    @Override
    public Optional<Order> searchOrder(long ID) {
        Optional<Order> orderOptional = Optional.ofNullable(orderRepository.getOrder(ID));
        return orderOptional;
    }
}
