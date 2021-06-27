package eu.exposit.consoleApp.datastorage;

import eu.exposit.consoleApp.api.datastorage.StoreDataStorage;
import eu.exposit.consoleApp.model.Store;

public class StoreDataStorageImpl extends AbstractDataStorageImpl<Store> implements StoreDataStorage {

    private static StoreDataStorage instance;

    public static StoreDataStorage getInstance() {
        if (instance == null) {
            instance = new StoreDataStorageImpl();
        }
        return instance;
    }
}
