package eu.exposit.consoleApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order extends BaseEntity {

    private String address;
    private Client client;
    private List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", client=" + client +
                ", products=" + products +
                '}';
    }
}
