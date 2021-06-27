package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByAttributes implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        System.out.println("""
                Осуществить поиск по:
                1 - Цена
                2 - Цена и вес"""
        );

        int choose = ConsoleIn.getScanner().nextInt();
        float maxPrice, maxWeight;
        List<Product> findProducts;
        switch (choose) {
            case 1 -> {
                System.out.println("Введите максимальную цену:");
                maxPrice = ConsoleIn.getScanner().nextFloat();

                for (Store store : storeController.getAllStore()) {
                    findProducts = store.getProducts().stream()
                            .filter(product -> product.getPrice() <= maxPrice)
                            .collect(Collectors.toList());
                    System.out.println("Продукты в пределах заданной цены в магазине " + store.getName() + ":");
                    System.out.println(findProducts);
                }
            }
            case 2 -> {
                System.out.println("Введите максимальную цену:");
                maxPrice = ConsoleIn.getScanner().nextFloat();

                System.out.println("Введите максимальный вес:");
                maxWeight = ConsoleIn.getScanner().nextFloat();

                for (Store store : storeController.getAllStore()) {
                    findProducts = store.getProducts().stream()
                            .filter(product -> product.getPrice() <= maxPrice)
                            .filter(product -> product.getWeight() <= maxWeight)
                            .collect(Collectors.toList());
                    System.out.println("Продукты в пределах заданной цены и веса в магазине " + store.getName() + ":");
                    System.out.println(findProducts);
                }
            }
            default -> {
                System.out.println("Ошибка ввода!");
            }
        }
    }
}
