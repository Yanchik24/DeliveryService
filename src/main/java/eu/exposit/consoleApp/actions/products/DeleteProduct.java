package eu.exposit.consoleApp.actions.products;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ProductGsonParser;
import eu.exposit.consoleApp.controllers.ProductController;
import eu.exposit.consoleApp.model.Product;
import eu.exposit.consoleApp.parsers.ProductParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.List;

public class DeleteProduct implements Action {
    @Override
    public void execute() throws Exception {
        ProductController productController = ProductController.getInstance();
        ProductGsonParser parser = ProductParserImpl.getInstance();
        List<Product> products = parser.readFile();

        System.out.println("Введите id продукта для удаления:");
        int id = ConsoleIn.getScanner().nextInt(), a = 0;

        while (id < 0 || id >= productController.getAllProduct().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        products.remove(id);

        for (int i = id; i < products.size(); i++) {
            products.get(i).setId(i);
        }
        ProductController.getInstance().getAllProduct().clear();

        for (Product product : products) {
            ProductController.getInstance().addProduct(product.getName(),
                    product.getAmount(),
                    product.getPrice(),
                    product.getWeight(),
                    product.getCategory());
        }

        for (Product product : ProductController.getInstance().getAllProduct()) {
            product.setId(a);
            a++;
        }
        parser.writeFile(products);
    }
}
