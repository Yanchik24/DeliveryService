package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.model.enumType.ProductCategory;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByCategory implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        List<ProductCategory> categories = new ArrayList<>();
        ProductCategory[] value = ProductCategory.values();

        while (true) {
            System.out.println("Выберите категории по которым осуществить поиск (для выхода введите '0'):");
            for (int i = 1; i < value.length + 1; i++) {
                System.out.println(i + " - " + value[i - 1].getName());
            }
            int a = ConsoleIn.getScanner().nextInt();

            while (a < 0 || a > value.length) {
                System.out.println("Введите ещё раз:");
                a = ConsoleIn.getScanner().nextInt();
            }
            if (a == 0) {
                break;
            }
            categories.add(value[a - 1]);
        }

        categories = categories.stream().distinct().collect(Collectors.toList());
        Collections.sort(categories);
        for (Store store : storeController.getAllStore()) {
            System.out.println(store.getName() + ':');
            for (Product product : store.getProducts()) {
                Collections.sort(product.getCategory());
                if (categories.equals(product.getCategory())) {
                    System.out.println(product + "\n");
                }
            }
        }
    }
}
