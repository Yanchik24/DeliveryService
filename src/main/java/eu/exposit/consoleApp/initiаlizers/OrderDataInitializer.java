package eu.exposit.consoleApp.initiаlizers;

import eu.exposit.consoleApp.api.datastorage.OrderDataStorage;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.controllers.OrderController;
import eu.exposit.consoleApp.datastorage.OrderDataStorageImpl;
import eu.exposit.consoleApp.model.Order;
import eu.exposit.consoleApp.parsers.OrderParserImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderDataInitializer implements Initializer {
    @Override
    public void init() {
        OrderDataStorage orderDataStorage = OrderDataStorageImpl.getInstance();
        orderDataStorage.setEntities(new ArrayList<>());

        List<Order> orders = OrderParserImpl.getInstance().readFile();

        for (Order order : orders) {
            OrderController.getInstance().addOrder(order.getAddress(),
                    order.getClient(),
                    order.getProducts());
        }
    }
}
