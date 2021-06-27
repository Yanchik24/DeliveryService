package eu.exposit.consoleApp.api.initializers;

public interface Initializer {

    String clientPath = "src/main/resources/json/clients.json";
    String productPath = "src/main/resources/json/products.json";
    String storePath = "src/main/resources/json/stores.json";
    String orderPath = "src/main/resources/json/orders.json";

    void init();
}
