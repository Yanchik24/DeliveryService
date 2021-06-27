package eu.exposit.consoleApp.services;

import eu.exposit.consoleApp.api.repositories.ClientRepository;
import eu.exposit.consoleApp.api.services.ClientService;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.repositories.ClientRepositoryImpl;

public class ClientServiceImpl extends AbstractServiceImpl<Client> implements ClientService {

    private static ClientService instance;

    private static ClientRepository clientRepository;

    public ClientServiceImpl() {
        super(ClientRepositoryImpl.getInstance());
        clientRepository = (ClientRepository) abstractRepository;
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }
}
