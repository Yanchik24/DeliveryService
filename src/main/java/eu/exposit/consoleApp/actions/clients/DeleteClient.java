package eu.exposit.consoleApp.actions.clients;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ClientGsonParser;
import eu.exposit.consoleApp.controllers.ClientController;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.Client;
import eu.exposit.consoleApp.parsers.ClientParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;

import java.util.List;

public class DeleteClient implements Action {
    @Override
    public void execute() throws NoSuitableEntryException {
        ClientController clientController = ClientController.getInstance();
        ClientGsonParser parser = ClientParserImpl.getInstance();
        List<Client> clients = parser.readFile();

        System.out.println("Введите id клиента для удаления:");
        int id = ConsoleIn.getScanner().nextInt(), a = 0;

        while (id < 0 || id >= clientController.getAllClient().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        clients.remove(id);

        for (int i = id; i < clients.size(); i++) {
            clients.get(i).setId(i);
        }
        ClientController.getInstance().getAllClient().clear();

        for (Client client : clients) {
            ClientController.getInstance().registrationClient(client.getName(),
                    client.getSurname(),
                    client.getMail(),
                    client.getCellphone());
        }

        for (Client client : ClientController.getInstance().getAllClient()) {
            client.setId(a);
            a++;
        }
        parser.writeFile(clients);
    }
}
