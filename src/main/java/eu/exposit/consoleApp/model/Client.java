package eu.exposit.consoleApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Client extends BaseEntity {

    private String name;
    private String surname;
    private String mail;
    private String cellphone;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
