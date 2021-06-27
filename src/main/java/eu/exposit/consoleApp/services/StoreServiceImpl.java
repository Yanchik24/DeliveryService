package eu.exposit.consoleApp.services;

import eu.exposit.consoleApp.api.repositories.StoreRepository;
import eu.exposit.consoleApp.api.services.StoreService;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.repositories.StoreRepositoryImpl;

public class StoreServiceImpl extends AbstractServiceImpl<Store> implements StoreService {
    private static StoreService instance;

    private static StoreRepository storeRepository;

    public StoreServiceImpl() {
        super(StoreRepositoryImpl.getInstance());
        storeRepository = (StoreRepository) abstractRepository;
    }

    public static StoreService getInstance() {
        if (instance == null) {
            instance = new StoreServiceImpl();
        }
        return instance;
    }
}
