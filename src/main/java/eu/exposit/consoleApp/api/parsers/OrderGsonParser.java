package eu.exposit.consoleApp.api.parsers;

import eu.exposit.consoleApp.model.Order;

import java.util.List;

public interface OrderGsonParser {

    List<Order> readFile();

    void writeFile(List<Order> orders);
}
