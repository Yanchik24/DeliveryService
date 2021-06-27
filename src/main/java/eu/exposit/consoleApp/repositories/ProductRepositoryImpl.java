package eu.exposit.consoleApp.repositories;

import eu.exposit.consoleApp.api.datastorage.ProductDataStorage;
import eu.exposit.consoleApp.api.repositories.ProductRepository;
import eu.exposit.consoleApp.datastorage.ProductDataStorageImp;
import eu.exposit.consoleApp.model.Product;

public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {

    private static ProductRepository instance;

    private static ProductDataStorage productDataStorage;

    public ProductRepositoryImpl() {
        super(ProductDataStorageImp.getInstance());
        productDataStorage = (ProductDataStorage) abstractDataStorage;
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl();
        }
        return instance;
    }

}
