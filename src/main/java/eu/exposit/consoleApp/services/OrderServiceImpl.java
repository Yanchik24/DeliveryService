package eu.exposit.consoleApp.services;

import eu.exposit.consoleApp.api.repositories.OrderRepository;
import eu.exposit.consoleApp.api.services.OrderService;
import eu.exposit.consoleApp.model.Order;
import eu.exposit.consoleApp.repositories.OrderRepositoryImpl;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {
    private static OrderService instance;

    private static OrderRepository orderRepository;

    public OrderServiceImpl() {
        super(OrderRepositoryImpl.getInstance());
        orderRepository = (OrderRepository) abstractRepository;
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }
}
