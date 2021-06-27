package eu.exposit.consoleApp.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.api.parsers.ProductGsonParser;
import eu.exposit.consoleApp.model.Product;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductParserImpl implements ProductGsonParser {

    private static ProductGsonParser instance;

    public static ProductGsonParser getInstance() {
        if (instance == null) {
            instance = new ProductParserImpl();
        }
        return instance;
    }

    private static final Gson gson = new Gson();

    @Override
    public List<Product> readFile() {
        try (FileReader reader = new FileReader(Initializer.productPath)) {
            return gson.fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }

    public void writeFile(List<Product> products) {
        try (FileWriter writer = new FileWriter(Initializer.productPath)) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
