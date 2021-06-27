package eu.exposit.consoleApp.actions.clients;

import eu.exposit.consoleApp.actions.Action;
import eu.exposit.consoleApp.api.parsers.ClientGsonParser;
import eu.exposit.consoleApp.controllers.ClientController;
import eu.exposit.consoleApp.parsers.ClientParserImpl;
import eu.exposit.consoleApp.utils.ConsoleIn;
import eu.exposit.consoleApp.utils.EmailValidator;

public class RegistrationClient implements Action {
    @Override
    public void execute() {
        ClientController clientController = ClientController.getInstance();
        ClientGsonParser parser = ClientParserImpl.getInstance();
        EmailValidator emailValidator = EmailValidator.getInstance();

        System.out.println("- Регистрация клиента");

        System.out.println("Введите имя:");
        String name = ConsoleIn.getScanner().nextLine();

        System.out.println("Введите фамилию:");
        String surname = ConsoleIn.getScanner().nextLine();

        System.out.println("Введите почту пользователя:");
        String mail = ConsoleIn.getScanner().nextLine();
        while (!emailValidator.validate(mail)) {
            System.out.println("Введите корректную почту: ");
            mail = ConsoleIn.getScanner().nextLine();
        }

        System.out.println("Введите телефон пользователя:");
        String cellphone = ConsoleIn.getScanner().nextLine();

        clientController.registrationClient(name, surname, mail, cellphone);
        parser.writeFile(clientController.getAllClient());
    }
}
