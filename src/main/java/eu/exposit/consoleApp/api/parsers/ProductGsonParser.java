package eu.exposit.consoleApp.api.parsers;

import eu.exposit.consoleApp.model.Product;

import java.util.List;

public interface ProductGsonParser {

    List<Product> readFile();

    void writeFile(List<Product> products);
}
