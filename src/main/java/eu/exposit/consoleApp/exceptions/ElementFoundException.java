package eu.exposit.consoleApp.exceptions;

public class ElementFoundException extends Exception {
    public ElementFoundException() {
        super("Список элементов пуст!");
    }
}
