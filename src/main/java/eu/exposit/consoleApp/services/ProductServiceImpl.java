package eu.exposit.consoleApp.services;

import eu.exposit.consoleApp.api.repositories.ProductRepository;
import eu.exposit.consoleApp.api.services.ProductService;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.repositories.ProductRepositoryImpl;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {

    private static ProductService instance;

    private static ProductRepository productRepository;

    public ProductServiceImpl() {
        super(ProductRepositoryImpl.getInstance());
        productRepository = (ProductRepository) abstractRepository;
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

}
