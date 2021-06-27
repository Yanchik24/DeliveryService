package eu.exposit.consoleApp.actions.orders;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.OrderGsonParser;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.controllers.ClientController;
import eu.exposit.consoleApp.controllers.OrderController;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.model.enumType.ProductCategory;
import eu.exposit.consoleApp.parsers.OrderParserImpl;
import eu.exposit.consoleApp.parsers.StoreParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.ArrayList;
import java.util.List;

public class AddOrder implements Action {
    @Override
    public void execute() throws Exception {

        OrderController orderController = OrderController.getInstance();
        ClientController clientController = ClientController.getInstance();
        StoreController storeController = StoreController.getInstance();
        OrderGsonParser orderParser = OrderParserImpl.getInstance();
        StoreGsonParser storeParser = StoreParserImpl.getInstance();
        List<ProductCategory> categories = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        int clientNumber, storeNumber, productNumber, amountProduct, amountAllProduct;
        float weightProduct, priceProduct;
        String address, name;

        System.out.println("- Оформление заказа");

        System.out.println("Выберите клиента:");
        for (int i = 1; i < clientController.getAllClient().size() + 1; i++) {
            System.out.println(i + " - " + clientController.getClient(i - 1));
        }
        clientNumber = ConsoleIn.getScanner().nextInt();
        while (clientNumber < 1 || clientNumber > clientController.getAllClient().size()) {
            System.out.println("Введите ещё раз:");
            clientNumber = ConsoleIn.getScanner().nextInt();
        }
        clientNumber -= 1;

        while (true) {
            System.out.println("Выберите магазин, что бы сделать заказ (для завершения заказа введите '0'):");
            for (int i = 1; i < storeController.getAllStore().size() + 1; i++) {
                System.out.println(i + " - " + storeController.getStore(i - 1));
            }
            storeNumber = ConsoleIn.getScanner().nextInt();
            while (storeNumber < 0 || storeNumber > storeController.getAllStore().size()) {
                System.out.println("Введите ещё раз:");
                storeNumber = ConsoleIn.getScanner().nextInt();
            }
            if (storeNumber == 0) {
                break;
            }
            storeNumber -= 1;
            System.out.println("Выберите продукт, который хотите заказать:");
            for (int i = 1; i < storeController.getStore(storeNumber).getProducts().size() + 1; i++) {
                System.out.println(i + " - " + storeController.getStore(storeNumber).getProducts().get(i - 1));
            }
            productNumber = ConsoleIn.getScanner().nextInt();
            while (productNumber < 1 || productNumber > storeController.getStore(storeNumber).getProducts().size()) {
                System.out.println("Введите ещё раз:");
                productNumber = ConsoleIn.getScanner().nextInt();
            }
            productNumber -= 1;
            if (storeController.getStore(storeNumber).getProducts().get(productNumber).getAmount() == 0) {
                System.out.println("Данного продукта нет на складе!");
                continue;
            }
            System.out.println("Введите необходимое количество:");
            amountProduct = ConsoleIn.getScanner().nextInt();

            while (amountProduct < 1 ||
                    amountProduct > storeController.getStore(storeNumber).getProducts().get(productNumber).getAmount()) {
                System.out.println("Такое количество недоступно, введите ещё раз: ");
                amountProduct = ConsoleIn.getScanner().nextInt();
            }

            weightProduct = storeController.getStore(storeNumber).getProducts().get(productNumber).getWeight();
            priceProduct = storeController.getStore(storeNumber).getProducts().get(productNumber).getPrice();
            amountAllProduct = storeController.getStore(storeNumber).getProducts().get(productNumber).getAmount();
            name = storeController.getStore(storeNumber).getProducts().get(productNumber).getName();
            categories = storeController.getStore(storeNumber).getProducts().get(productNumber).getCategory();
            storeController.getStore(storeNumber).getProducts().get(productNumber).setAmount(amountAllProduct - amountProduct);
            storeParser.writeFile(storeController.getAllStore());


            Product product = new Product(
                    name,
                    amountProduct,
                    priceProduct * amountProduct,
                    weightProduct * amountProduct,
                    categories
            );

            products.add(product);


        }
        System.out.println("Введите аддрес:");
        address = ConsoleIn.getScanner().next();

        orderController.addOrder(address, clientController.getClient(clientNumber), products);
        orderParser.writeFile(orderController.getAllOrder());
    }
}
