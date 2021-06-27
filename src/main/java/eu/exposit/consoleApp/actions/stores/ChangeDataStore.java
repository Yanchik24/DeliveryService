package eu.exposit.consoleApp.actions.stores;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.enumType.ProductCategory;
import eu.exposit.consoleApp.parsers.StoreParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeDataStore implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        StoreGsonParser parser = StoreParserImpl.getInstance();
        List<ProductCategory> categories = new ArrayList<>();
        float c;

        System.out.println("Введите id магазина, которого хотите изменить:");
        int id = ConsoleIn.getScanner().nextInt(), b, chooseCategory;

        while (id < 0 || id >= storeController.getAllStore().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        System.out.println("""
                Выберите поле которое хотите изменить:
                1 - Название
                2 - Продукты"""
        );

        int choose = ConsoleIn.getScanner().nextInt();
        String temp;
        switch (choose) {
            case 1 -> {
                System.out.println("Введите новое название магазина:");
                temp = ConsoleIn.getScanner().next();
                storeController.getStore(id).setName(temp);
                parser.writeFile(storeController.getAllStore());
            }
            case 2 -> {
                System.out.println("Выберите продукт который хотите изменить:");
                for (int i = 1; i < storeController.getStore(id).getProducts().size() + 1; i++) {
                    System.out.println(i + " - " + storeController.getStore(id).getProducts().get(i - 1));
                }
                int chooseProduct = ConsoleIn.getScanner().nextInt();
                while (chooseProduct < 1 || chooseProduct > storeController.getStore(id).getProducts().size()) {
                    System.out.println("Введите ещё раз:");
                    chooseProduct = ConsoleIn.getScanner().nextInt();
                }

                System.out.println("""
                        Выберите поле которое хотите изменить:
                        1 - Название
                        2 - Количество
                        3 - Цена
                        4 - Вес
                        5 - Категория"""
                );
                choose = ConsoleIn.getScanner().nextInt();
                chooseProduct -= 1;
                switch (choose) {
                    case 1 -> {
                        System.out.println("Введите новое название продукта:");
                        String name = ConsoleIn.getScanner().nextLine();
                        storeController.getStore(id).getProducts().get(chooseProduct).setName(name);
                        parser.writeFile(storeController.getAllStore());
                    }
                    case 2 -> {
                        System.out.println("Введите новое количество:");
                        b = ConsoleIn.getScanner().nextInt();
                        storeController.getStore(id).getProducts().get(chooseProduct).setAmount(b);
                        parser.writeFile(storeController.getAllStore());
                    }
                    case 3 -> {
                        System.out.println("Введите новую цену:");
                        c = ConsoleIn.getScanner().nextFloat();
                        storeController.getStore(id).getProducts().get(chooseProduct).setPrice(c);
                        parser.writeFile(storeController.getAllStore());
                    }
                    case 4 -> {
                        System.out.println("Введите новый вес:");
                        c = ConsoleIn.getScanner().nextFloat();
                        storeController.getStore(id).getProducts().get(chooseProduct).setWeight(c);
                        parser.writeFile(storeController.getAllStore());
                    }
                    case 5 -> {
                        ProductCategory[] value = ProductCategory.values();
                        while (true) {
                            System.out.println("Выберите новую категорию (для выхода введите '0'):");
                            for (int i = 1; i < value.length + 1; i++) {
                                System.out.println(i + " - " + value[i - 1].getName());
                            }
                            chooseCategory = ConsoleIn.getScanner().nextInt();
                            if (chooseCategory == 0) {
                                break;
                            }
                            while (chooseCategory < 1 || chooseCategory > value.length) {
                                System.out.println("Введите ещё раз:");
                                chooseCategory = ConsoleIn.getScanner().nextInt();
                            }
                            categories.add(value[chooseCategory - 1]);
                        }
                        categories = categories.stream().distinct().collect(Collectors.toList());
                        storeController.getStore(id).getProducts().get(chooseProduct).setCategory(categories);
                        parser.writeFile(storeController.getAllStore());
                    }
                    default -> System.out.println("Некорректный ввод!");
                }
            }
            default -> System.out.println("Некорректный ввод!");
        }
    }
}
