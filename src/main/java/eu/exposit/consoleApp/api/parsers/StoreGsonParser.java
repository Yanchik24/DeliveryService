package eu.exposit.consoleApp.api.parsers;

import eu.exposit.consoleApp.model.Store;

import java.util.List;

public interface StoreGsonParser {

    List<Store> readFile();

    void writeFile(List<Store> stores);
}
