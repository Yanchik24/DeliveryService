package eu.exposit.consoleApp.controllers;

import eu.exposit.consoleApp.api.services.ClientService;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.services.ClientServiceImpl;

import java.util.List;

public class ClientController {

    private final ClientService clientService;

    private static ClientController instance;

    private ClientController() {
        this.clientService = ClientServiceImpl.getInstance();
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Client getClient(long id) throws NoSuitableEntryException {
        return clientService.get(id);
    }

    public long registrationClient(String name, String surname, String mail, String cellphone) {
        return clientService.create(new Client(name, surname, mail, cellphone));
    }

    public List<Client> getAllClient() {
        return clientService.getAll();
    }

}
