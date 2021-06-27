package eu.exposit.consoleApp.api.parsers;

import eu.exposit.consoleApp.model.Client;

import java.util.List;

public interface ClientGsonParser {

    List<Client> readFile();

    void writeFile(List<Client> clients);
}
