package eu.exposit.consoleApp.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.api.parsers.OrderGsonParser;
import eu.exposit.consoleApp.model.Order;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderParserImpl implements OrderGsonParser {

    private static OrderGsonParser instance;

    public static OrderGsonParser getInstance() {
        if (instance == null) {
            instance = new OrderParserImpl();
        }
        return instance;
    }

    private static final Gson gson = new Gson();

    @Override
    public List<Order> readFile() {
        try (FileReader reader = new FileReader(Initializer.orderPath)) {
            return gson.fromJson(reader, new TypeToken<List<Order>>() {
            }.getType());

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }

    @Override
    public void writeFile(List<Order> orders) {
        try (FileWriter writer = new FileWriter(Initializer.orderPath)) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
