package eu.exposit.consoleApp.datastorage;

import eu.exposit.consoleApp.api.datastorage.ProductDataStorage;
import eu.exposit.consoleApp.model.Product;

public class ProductDataStorageImp extends AbstractDataStorageImpl<Product> implements ProductDataStorage {

    private static ProductDataStorage instance;

    public static ProductDataStorage getInstance() {
        if (instance == null) {
            instance = new ProductDataStorageImp();
        }
        return instance;
    }
}
