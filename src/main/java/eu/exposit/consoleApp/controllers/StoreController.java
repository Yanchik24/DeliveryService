package eu.exposit.consoleApp.controllers;

import eu.exposit.consoleApp.api.services.StoreService;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.services.StoreServiceImpl;

import java.util.List;

public class StoreController {

    private final StoreService storeService;

    private static StoreController instance;

    private StoreController() {
        this.storeService = StoreServiceImpl.getInstance();
    }

    public static StoreController getInstance() {
        if (instance == null) {
            instance = new StoreController();
        }
        return instance;
    }

    public Store getStore(long id) throws NoSuitableEntryException {
        return storeService.get(id);
    }

    public long registrationStore(String name, List<Product> products) {
        return storeService.create(new Store(name, products));
    }

    public List<Store> getAllStore() {
        return storeService.getAll();
    }
}
