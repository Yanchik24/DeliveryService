package eu.exposit.consoleApp.actions.clients;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ClientGsonParser;
import eu.exposit.consoleApp.exceptions.ElementFoundException;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.parsers.ClientParserImpl;

import java.util.List;

public class DisplayAllClients implements Action {
    @Override
    public void execute() throws ElementFoundException {
        ClientGsonParser parser = ClientParserImpl.getInstance();
        List<Client> clients;

        clients = parser.readFile();
        if (clients.isEmpty()) {
            throw new ElementFoundException();
        }

        for (Client client : clients) {
            System.out.println(client.getId() + " " + client.toString());
        }
    }
}
