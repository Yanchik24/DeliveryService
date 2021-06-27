package eu.exposit.consoleApp.initiаlizers;

import eu.exposit.consoleApp.api.datastorage.StoreDataStorage;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.datastorage.StoreDataStorageImpl;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.parsers.StoreParserImpl;

import java.util.ArrayList;
import java.util.List;

public class StoreDataInitializer implements Initializer {
    @Override
    public void init() {
        StoreDataStorage storeDataStorage = StoreDataStorageImpl.getInstance();
        storeDataStorage.setEntities(new ArrayList<>());

        List<Store> stores = StoreParserImpl.getInstance().readFile();

        for (Store store : stores) {
            StoreController.getInstance().registrationStore(store.getName(),
                    store.getProducts());
        }
    }
}
