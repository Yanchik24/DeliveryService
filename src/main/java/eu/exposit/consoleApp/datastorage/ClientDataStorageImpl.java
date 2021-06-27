package eu.exposit.consoleApp.datastorage;

import eu.exposit.consoleApp.api.datastorage.ClientDataStorage;
import eu.exposit.consoleApp.model.Client;

public class ClientDataStorageImpl extends AbstractDataStorageImpl<Client> implements ClientDataStorage {

    private static ClientDataStorage instance;

    public static ClientDataStorage getInstance() {
        if (instance == null) {
            instance = new ClientDataStorageImpl();
        }
        return instance;
    }
}
