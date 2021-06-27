package eu.exposit.consoleApp.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.exposit.consoleApp.api.initializers.Initializer;
import eu.exposit.consoleApp.api.parsers.StoreGsonParser;
import eu.exposit.consoleApp.model.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StoreParserImpl implements StoreGsonParser {

    private static StoreGsonParser instance;

    public static StoreGsonParser getInstance() {
        if (instance == null) {
            instance = new StoreParserImpl();
        }
        return instance;
    }

    private static final Gson gson = new Gson();

    @Override
    public List<Store> readFile() {
        try (FileReader reader = new FileReader(Initializer.storePath)) {
            return gson.fromJson(reader, new TypeToken<List<Store>>() {
            }.getType());

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }

    @Override
    public void writeFile(List<Store> stores) {
        try (FileWriter writer = new FileWriter(Initializer.storePath)) {
            gson.toJson(stores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
