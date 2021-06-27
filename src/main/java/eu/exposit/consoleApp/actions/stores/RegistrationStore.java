package eu.exposit.consoleApp.actions.stores;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ProductGsonParser;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.parsers.ProductParserImpl;
import eu.exposit.consoleApp.parsers.StoreParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationStore implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        StoreGsonParser storeParser = StoreParserImpl.getInstance();
        ProductGsonParser productParser = ProductParserImpl.getInstance();
        List<Product> allProducts = productParser.readFile();
        List<Product> storeProducts = new ArrayList<>();

        System.out.println("- Регистрация магазина");

        System.out.println("Введите название:");
        String name = ConsoleIn.getScanner().next();

        while (true) {
            System.out.println("Выберите продуткы (для создания магазина введите '0'):");
            for (int i = 1; i < allProducts.size() + 1; i++) {
                System.out.println(i + " - " + allProducts.get(i - 1));
            }
            int a = ConsoleIn.getScanner().nextInt();

            while (a < 0 || a > allProducts.size()) {
                System.out.println("Введите ещё раз:");
                a = ConsoleIn.getScanner().nextInt();
            }
            if (a == 0) {
                break;
            }
            storeProducts.add(allProducts.get(a - 1));
        }
        storeProducts = storeProducts.stream().distinct().collect(Collectors.toList());
        storeController.registrationStore(name, storeProducts);
        storeParser.writeFile(storeController.getAllStore());
    }
}
