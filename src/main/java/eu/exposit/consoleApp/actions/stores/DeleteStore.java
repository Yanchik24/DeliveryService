package eu.exposit.consoleApp.actions.stores;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.controllers.StoreController;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.parsers.StoreParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.List;

public class DeleteStore implements Action {
    @Override
    public void execute() throws Exception {
        StoreController storeController = StoreController.getInstance();
        StoreGsonParser parser = StoreParserImpl.getInstance();
        List<Store> stores = parser.readFile();

        System.out.println("Введите id магазина для удаления:");
        int id = ConsoleIn.getScanner().nextInt(), a = 0;

        while (id < 0 || id >= storeController.getAllStore().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        stores.remove(id);

        for (int i = id; i < stores.size(); i++) {
            stores.get(i).setId(i);
        }
        StoreController.getInstance().getAllStore().clear();

        for (Store store : stores) {
            StoreController.getInstance().registrationStore(store.getName(),
                    store.getProducts());
        }

        for (Store store : StoreController.getInstance().getAllStore()) {
            store.setId(a);
            a++;
        }
        parser.writeFile(stores);
    }
}
