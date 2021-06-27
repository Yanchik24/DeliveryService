package eu.exposit.consoleApp.menu;

import eu.exposit.consoleApp.actions.ActionExecutor;
import eu.exposit.consoleApp.actions.clients.ChangeDataClient;
import eu.exposit.consoleApp.actions.clients.DeleteClient;
import eu.exposit.consoleApp.actions.clients.DisplayAllClients;
import eu.exposit.consoleApp.actions.clients.RegistrationClient;
import eu.exposit.consoleApp.actions.orders.AddOrder;
import eu.exposit.consoleApp.actions.orders.DisplayAllOrders;
import eu.exposit.consoleApp.actions.products.*;
import eu.exposit.consoleApp.actions.stores.ChangeDataStore;
import eu.exposit.consoleApp.actions.stores.DeleteStore;
import eu.exposit.consoleApp.actions.stores.DisplayAllStores;
import eu.exposit.consoleApp.actions.stores.RegistrationStore;
import eu.exposit.consoleApp.utils.ConsoleIn;

public class ConsoleInterface {
    public static void Menu() {
        int choose, chooseSubmenu;
        while (true) {
            System.out.println("""
                    
                    1 - Регистрация клиентов, с возможностью удаления и изменения регистрационных данных
                    2 - Регистрация магазинов, с возможностью удаления и изменения регистрационных данных
                    3 - Добавление/удаление/редактирование информации о товарах
                    4 - Поиск товаров по одному или нескольким атрибутам
                    5 - Обновление информации о количестве и цене на товары в заданном магазине. Обратите внимание, что цены на одинаковые товары в разных магазинах могут отличаться
                    6 - Сортировка товаров по цене
                    7 - Просмотр товаров в заданных категориях
                    8 - Оформление заказа, с указанием данных клиента и данных, связанных с доставкой
                    9 - Просмотр заказов
                    10 - Выход из программы""");
            choose = ConsoleIn.getScanner().nextInt();
            while (choose < 1 || choose > 10) {
                System.out.println("Введите ещё раз:");
                choose = ConsoleIn.getScanner().nextInt();
            }
            switch (choose) {
                case 1 -> {
                    System.out.println("""
                             1 - Регистрация клиентов
                             2 - Удаление клиентов 
                             3 - Изменения регистрационных данных клиентов
                             4 - Просмотр клиентов 
                            """);
                    chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    while (chooseSubmenu < 1 || chooseSubmenu > 4) {
                        System.out.println("Введите ещё раз:");
                        chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    }
                    switch (chooseSubmenu) {
                        case 1 -> ActionExecutor.execute(new RegistrationClient());

                        case 2 -> ActionExecutor.execute(new DeleteClient());

                        case 3 -> ActionExecutor.execute(new ChangeDataClient());

                        case 4 -> ActionExecutor.execute(new DisplayAllClients());

                        default -> System.out.println("Ошибка ввода!");
                    }
                }
                case 2 -> {
                    System.out.println("""
                             1 - Регистрация магазинов
                             2 - Удаление магазинов 
                             3 - Изменения регистрационных данных магазинов
                             4 - Просмотр магазинов 
                            """);
                    chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    while (chooseSubmenu < 1 || chooseSubmenu > 4) {
                        System.out.println("Введите ещё раз:");
                        chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    }
                    switch (chooseSubmenu) {
                        case 1 -> ActionExecutor.execute(new RegistrationStore());

                        case 2 -> ActionExecutor.execute(new DeleteStore());

                        case 3 -> ActionExecutor.execute(new ChangeDataStore());

                        case 4 -> ActionExecutor.execute(new DisplayAllStores());

                        default -> System.out.println("Ошибка ввода!");
                    }
                }
                case 3 -> {
                    System.out.println("""
                             1 - Добавление товаров
                             2 - Удаление товаров
                             3 - Изменения регистрационных данных товаров
                             4 - Просмотр товаров 
                            """);
                    chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    while (chooseSubmenu < 1 || chooseSubmenu > 4) {
                        System.out.println("Введите ещё раз:");
                        chooseSubmenu = ConsoleIn.getScanner().nextInt();
                    }
                    switch (chooseSubmenu) {
                        case 1 -> ActionExecutor.execute(new AddProduct());

                        case 2 -> ActionExecutor.execute(new DeleteProduct());

                        case 3 -> ActionExecutor.execute(new ChangeDataProduct());

                        case 4 -> ActionExecutor.execute(new DisplayAllProducts());

                        default -> System.out.println("Ошибка ввода!");
                    }
                }
                case 4 -> ActionExecutor.execute(new SearchByAttributes());
                case 5 -> ActionExecutor.execute(new ChangeDataStore());
                case 6 -> ActionExecutor.execute(new SortByPrice());
                case 7 -> ActionExecutor.execute(new SearchByCategory());
                case 8 -> ActionExecutor.execute(new AddOrder());
                case 9 -> ActionExecutor.execute(new DisplayAllOrders());
                case 10 -> System.exit(0);
            }
        }
    }
}
