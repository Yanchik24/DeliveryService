package eu.exposit.consoleApp.controllers;

import eu.exposit.consoleApp.api.services.ProductService;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.enumType.ProductCategory;
import eu.exposit.consoleApp.services.ProductServiceImpl;

import java.util.List;

public class ProductController {
    private final ProductService productService;

    private static ProductController instance;

    private ProductController() {
        this.productService = ProductServiceImpl.getInstance();
    }

    public static ProductController getInstance() {
        if (instance == null) {
            instance = new ProductController();
        }
        return instance;
    }

    public Product getProduct(long id) throws NoSuitableEntryException {
        return productService.get(id);
    }

    public long addProduct(String name, int amount, float price, float weight, List<ProductCategory> categories) {
        return productService.create(new Product(name, amount, price, weight, categories));
    }

    public List<Product> getAllProduct() {
        return productService.getAll();
    }
}
