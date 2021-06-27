package eu.exposit.consoleApp.initiаlizers;

import eu.exposit.consoleApp.api.datastorage.ProductDataStorage;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.controllers.ProductController;
import eu.exposit.consoleApp.datastorage.ProductDataStorageImp;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.parsers.ProductParserImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductDataInitializer implements Initializer {

    @Override
    public void init() {
        ProductDataStorage productDataStorage = ProductDataStorageImp.getInstance();
        productDataStorage.setEntities(new ArrayList<>());

        List<Product> products = ProductParserImpl.getInstance().readFile();

        for (Product product : products) {
            ProductController.getInstance().addProduct(product.getName(),
                    product.getAmount(),
                    product.getPrice(),
                    product.getWeight(),
                    product.getCategory());
        }
    }
}
