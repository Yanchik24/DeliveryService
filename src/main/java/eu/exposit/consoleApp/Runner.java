package eu.exposit.consoleApp;

import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.initiаlizers.ClientDataInitializer;
import eu.exposit.consoleApp.initiаlizers.OrderDataInitializer;
import eu.exposit.consoleApp.initiаlizers.ProductDataInitializer;
import eu.exposit.consoleApp.initiаlizers.StoreDataInitializer;
import eu.exposit.consoleApp.menu.ConsoleInterface;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Initializer> initializers = Arrays.asList(
                new ClientDataInitializer(),
                new ProductDataInitializer(),
                new StoreDataInitializer(),
                new OrderDataInitializer()
        );

        initializers.forEach(Initializer::init);

        ConsoleInterface.Menu();
    }
}
