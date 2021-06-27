package eu.exposit.consoleApp.initiаlizers;

import eu.exposit.consoleApp.api.datastorage.ClientDataStorage;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.controllers.ClientController;
import eu.exposit.consoleApp.datastorage.ClientDataStorageImpl;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.parsers.ClientParserImpl;

import java.util.ArrayList;
import java.util.List;

public class ClientDataInitializer implements Initializer {

    public void init() {
        ClientDataStorage clientDataStorage = ClientDataStorageImpl.getInstance();
        clientDataStorage.setEntities(new ArrayList<>());

        List<Client> clients = ClientParserImpl.getInstance().readFile();

        for (Client client : clients) {
            ClientController.getInstance().registrationClient(client.getName(),
                    client.getSurname(),
                    client.getMail(),
                    client.getCellphone());
        }
    }
}
