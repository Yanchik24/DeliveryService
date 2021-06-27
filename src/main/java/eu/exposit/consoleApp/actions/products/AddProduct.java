package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ProductGsonParser;
import eu.exposit.consoleApp.controllers.ProductController;
import eu.exposit.consoleApp.model.enumType.ProductCategory;
import eu.exposit.consoleApp.parsers.ProductParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddProduct implements Action {
    @Override
    public void execute() throws Exception {

        ProductController productController = ProductController.getInstance();
        ProductGsonParser parser = ProductParserImpl.getInstance();
        List<ProductCategory> categories = new ArrayList<>();

        System.out.println("- Добавление продукта");

        System.out.println("Введите название продукта:");
        String name = ConsoleIn.getScanner().next();

        System.out.println("Введите количество:");
        int amount = ConsoleIn.getScanner().nextInt();

        System.out.println("Введите цену:");
        float price = ConsoleIn.getScanner().nextFloat();

        System.out.println("Введите вес:");
        float weight = ConsoleIn.getScanner().nextFloat();

        ProductCategory[] value = ProductCategory.values();
        while (true) {
            System.out.println("Выберите подходящую категорию (для создания введите '0'):");
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
        categories = categories.stream().distinct().collect(Collectors.toList()); //удаление повторяющихся продуктов
        productController.addProduct(name, amount, price, weight, categories);
        parser.writeFile(productController.getAllProduct());
    }
}
