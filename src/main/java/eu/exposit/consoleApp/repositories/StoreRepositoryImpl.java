package eu.exposit.consoleApp.repositories;

import eu.exposit.consoleApp.api.datastorage.StoreDataStorage;
import eu.exposit.consoleApp.api.repositories.StoreRepository;
import eu.exposit.consoleApp.datastorage.StoreDataStorageImpl;
import eu.exposit.consoleApp.model.Store;

public class StoreRepositoryImpl extends AbstractRepositoryImpl<Store> implements StoreRepository {
    private static StoreRepository instance;

    private static StoreDataStorage storeDataStorage;

    public StoreRepositoryImpl() {
        super(StoreDataStorageImpl.getInstance());
        storeDataStorage = (StoreDataStorage) abstractDataStorage;
    }

    public static StoreRepository getInstance() {
        if (instance == null) {
            instance = new StoreRepositoryImpl();
        }
        return instance;
    }

}
