package eu.exposit.consoleApp.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.api.parsers.ClientGsonParser;
import eu.exposit.consoleApp.model.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ClientParserImpl implements ClientGsonParser {

    private static ClientGsonParser instance;

    public static ClientGsonParser getInstance() {
        if (instance == null) {
            instance = new ClientParserImpl();
        }
        return instance;
    }

    private static final Gson gson = new Gson();

    @Override
    public List<Client> readFile() {
        try (FileReader reader = new FileReader(Initializer.clientPath)) {
            return gson.fromJson(reader, new TypeToken<List<Client>>() {
            }.getType());

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }

    public void writeFile(List<Client> clients) {
        try (FileWriter writer = new FileWriter(Initializer.clientPath)) {
            gson.toJson(clients, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
