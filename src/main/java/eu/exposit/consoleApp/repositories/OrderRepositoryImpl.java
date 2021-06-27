package eu.exposit.consoleApp.repositories;

import eu.exposit.consoleApp.api.datastorage.OrderDataStorage;
import eu.exposit.consoleApp.api.repositories.OrderRepository;
import eu.exposit.consoleApp.datastorage.OrderDataStorageImpl;
import eu.exposit.consoleApp.model.Order;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {

    private static OrderRepository instance;

    private static OrderDataStorage orderDataStorage;

    public OrderRepositoryImpl() {
        super(OrderDataStorageImpl.getInstance());
        orderDataStorage = (OrderDataStorage) abstractDataStorage;
    }

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepositoryImpl();
        }
        return instance;
    }
}
