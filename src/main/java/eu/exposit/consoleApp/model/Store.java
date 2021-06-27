package eu.exposit.consoleApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Store extends BaseEntity {

    private String name;
    private List<Product> products;

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
