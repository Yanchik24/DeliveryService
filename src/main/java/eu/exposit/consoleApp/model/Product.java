package eu.exposit.consoleApp.model;

import eu.exposit.consoleApp.model.enumType.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Product extends BaseEntity {

    private String name;
    private int amount;
    private float price;
    private float weight;
    private List<ProductCategory> category;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", weight=" + weight +
                ", category=" + category +
                '}';
    }
}
