package eu.exposit.consoleApp.repositories;

import eu.exposit.consoleApp.api.datastorage.ClientDataStorage;
import eu.exposit.consoleApp.api.repositories.ClientRepository;
import eu.exposit.consoleApp.datastorage.ClientDataStorageImpl;
import eu.exposit.consoleApp.model.Client;

public class ClientRepositoryImpl extends AbstractRepositoryImpl<Client> implements ClientRepository {

    private static ClientRepository instance;

    private static ClientDataStorage clientDataStorage;

    public ClientRepositoryImpl() {
        super(ClientDataStorageImpl.getInstance());
        clientDataStorage = (ClientDataStorage) abstractDataStorage;
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepositoryImpl();
        }
        return instance;
    }

}
