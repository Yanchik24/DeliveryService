package eu.exposit.consoleApp.actions.stores;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.exceptions.ElementFoundException;
import eu.exposit.consoleApp.model.Store;
import eu.exposit.consoleApp.parsers.StoreParserImpl;

import java.util.List;

public class DisplayAllStores implements Action {
    @Override
    public void execute() throws Exception {
        StoreGsonParser parser = StoreParserImpl.getInstance();
        List<Store> stores;

        stores = parser.readFile();
        if (stores.isEmpty()) {
            throw new ElementFoundException();
        }

        for (Store store : stores) {
            System.out.println(store.getId() + " " + store.toString());
        }
    }
}
