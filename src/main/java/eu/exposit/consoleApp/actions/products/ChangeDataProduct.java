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

public class ChangeDataProduct implements Action {
    @Override
    public void execute() throws Exception {
        ProductController productController = ProductController.getInstance();
        ProductGsonParser parser = ProductParserImpl.getInstance();
        List<ProductCategory> categories = new ArrayList<>();

        System.out.println("Введите id продукта, которого хотите изменить:");
        int id = ConsoleIn.getScanner().nextInt();

        while (id < 0 || id >= productController.getAllProduct().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        System.out.println("""
                Выберите поле которое хотите изменить:
                1 - Название
                2 - Количество
                3 - Цена
                4 - Вес
                5 - Категорию(-и)"""
        );


        int choose = ConsoleIn.getScanner().nextInt(), a;
        float b;
        String temp;
        switch (choose) {
            case 1 -> {
                System.out.println("Введите новое название продукта:");
                temp = ConsoleIn.getScanner().nextLine();
                productController.getProduct(id).setName(temp);
                parser.writeFile(productController.getAllProduct());
            }
            case 2 -> {
                System.out.println("Введите новое количество продуктов:");
                a = ConsoleIn.getScanner().nextInt();
                productController.getProduct(id).setAmount(a);
                parser.writeFile(productController.getAllProduct());
            }
            case 3 -> {
                System.out.println("Введите новую цену:");
                b = ConsoleIn.getScanner().nextInt();
                productController.getProduct(id).setPrice(b);
                parser.writeFile(productController.getAllProduct());
            }
            case 4 -> {
                System.out.println("Введите новый вес:");
                b = ConsoleIn.getScanner().nextInt();
                productController.getProduct(id).setWeight(b);
                parser.writeFile(productController.getAllProduct());
            }
            case 5 -> {
                ProductCategory[] value = ProductCategory.values();
                while (true) {
                    System.out.println("Выберите новую категорию (для выхода введите '0'):");
                    for (int i = 1; i < value.length + 1; i++) {
                        System.out.println(i + " - " + value[i - 1].getName());
                    }
                    a = ConsoleIn.getScanner().nextInt();
                    if (a == 0) {
                        break;
                    }
                    while (a < 1 || a > value.length) {
                        System.out.println("Введите ещё раз:");
                        a = ConsoleIn.getScanner().nextInt();
                    }
                    categories.add(value[a - 1]);
                }
                categories = categories.stream().distinct().collect(Collectors.toList());
                productController.getProduct(id).setCategory(categories);
                parser.writeFile(productController.getAllProduct());
            }
            default -> {
                System.out.println("Некорректный ввод!");
            }
        }
    }
}
