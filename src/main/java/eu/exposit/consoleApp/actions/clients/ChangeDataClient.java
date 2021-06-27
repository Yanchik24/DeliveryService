package eu.exposit.consoleApp.actions.clients;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ClientGsonParser;
import eu.exposit.consoleApp.controllers.ClientController;
import eu.exposit.consoleApp.parsers.ClientParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;
import eu.exposit.consoleApp.utils.EmailValidator;

public class ChangeDataClient implements Action {
    @Override
    public void execute() throws Exception {
        ClientController clientController = ClientController.getInstance();
        ClientGsonParser parser = ClientParserImpl.getInstance();
        EmailValidator emailValidator = EmailValidator.getInstance();

        System.out.println("Введите id клиента, которого хотите изменить:");
        int id = ConsoleIn.getScanner().nextInt();

        while (id < 0 || id >= clientController.getAllClient().size()) {
            System.out.println("Неверный ввод, попробуйте ещё раз:");
            id = ConsoleIn.getScanner().nextInt();
        }

        System.out.println("""
                Выберите поле которое хотите изменить:
                1 - Имя
                2 - Фамилия
                3 - электронная почта
                4 - мобильный телефон"""
        );

        int choose = ConsoleIn.getScanner().nextInt();
        String temp;
        switch (choose) {
            case 1 -> {
                System.out.println("Введите новое имя клиента:");
                temp = ConsoleIn.getScanner().next();
                clientController.getClient(id).setName(temp);
                parser.writeFile(clientController.getAllClient());
            }
            case 2 -> {
                System.out.println("Введите новую фамилию клиента:");
                temp = ConsoleIn.getScanner().next();
                clientController.getClient(id).setSurname(temp);
                parser.writeFile(clientController.getAllClient());
            }
            case 3 -> {
                System.out.println("Введите новую почту клиента:");
                temp = ConsoleIn.getScanner().next();
                while (!emailValidator.validate(temp)) {
                    System.out.println("Введите корректную почту: ");
                    temp = ConsoleIn.getScanner().next();
                }
                clientController.getClient(id).setMail(temp);
                parser.writeFile(clientController.getAllClient());
            }
            case 4 -> {
                System.out.println("Введите новый телефон клиента:");
                temp = ConsoleIn.getScanner().next();
                clientController.getClient(id).setCellphone(temp);
                parser.writeFile(clientController.getAllClient());
            }
            default -> {
                System.out.println("Некорректный ввод!");
            }
        }
    }
}
