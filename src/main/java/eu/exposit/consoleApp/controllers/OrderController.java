package eu.exposit.consoleApp.controllers;

import eu.exposit.consoleApp.api.services.OrderService;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.model.Order;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.services.OrderServiceImpl;

import java.util.List;

public class OrderController {

    private final OrderService orderService;

    private static OrderController instance;

    private OrderController() {
        this.orderService = OrderServiceImpl.getInstance();
    }

    public static OrderController getInstance() {
        if (instance == null) {
            instance = new OrderController();
        }
        return instance;
    }

    public Order getOrder(long id) throws NoSuitableEntryException {
        return orderService.get(id);
    }

    public long addOrder(String address, Client client, List<Product> products) {
        return orderService.create(new Order(address, client, products));
    }

    public List<Order> getAllOrder() {
        return orderService.getAll();
    }

}
