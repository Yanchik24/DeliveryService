package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.Store;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByPrice implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        List<Product> sortList;
        System.out.println("Сортировка по цене");
        for (Store store : storeController.getAllStore()) {
            sortList = store.getProducts().stream()
                    .sorted(Comparator.comparing(Product::getPrice))
                    .collect(Collectors.toList());
            System.out.println("Продукты отсортированные по цене в магазине " + store.getName() + ":");
            System.out.println(sortList);
        }
    }
}
