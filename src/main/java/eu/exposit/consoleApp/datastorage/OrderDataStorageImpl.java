package eu.exposit.consoleApp.datastorage;

import eu.exposit.consoleApp.api.datastorage.OrderDataStorage;
import eu.exposit.consoleApp.model.Order;

public class OrderDataStorageImpl extends AbstractDataStorageImpl<Order> implements OrderDataStorage {

    private static OrderDataStorage instance;

    public static OrderDataStorage getInstance() {
        if (instance == null) {
            instance = new OrderDataStorageImpl();
        }
        return instance;
    }
}
