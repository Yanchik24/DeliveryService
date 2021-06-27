package eu.exposit.consoleApp.exceptions;

public class NoSuitableEntryException extends Exception {
    public NoSuitableEntryException() {
        super("Соответствующая запись не найдена");
    }
}
