package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ProductGsonParser;
import eu.exposit.consoleApp.exceptions.ElementFoundException;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.parsers.ProductParserImpl;

import java.util.List;

public class DisplayAllProducts implements Action {
    @Override
    public void execute() throws Exception {
        ProductGsonParser parser = ProductParserImpl.getInstance();
        List<Product> products;

        products = parser.readFile();
        if (products.isEmpty()) {
            throw new ElementFoundException();
        }

        for (Product product : products) {
            System.out.println(product.getId() + " " + product.toString());
        }
    }
}
