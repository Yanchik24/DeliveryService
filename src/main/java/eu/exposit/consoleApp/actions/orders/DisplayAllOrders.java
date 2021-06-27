package eu.exposit.consoleApp.actions.orders;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.OrderGsonParser;
import eu.exposit.consoleApp.exceptions.ElementFoundException;
import eu.exposit.consoleApp.model.Order;
import eu.exposit.consoleApp.parsers.OrderParserImpl;

import java.util.List;

public class DisplayAllOrders implements Action {
    @Override
    public void execute() throws Exception {
        OrderGsonParser parser = OrderParserImpl.getInstance();
        List<Order> orders;

        orders = parser.readFile();
        if (orders.isEmpty()) {
            throw new ElementFoundException();
        }

        for (Order order : orders) {
            System.out.println(order.getId() + " " + order.toString());
        }
    }
}
