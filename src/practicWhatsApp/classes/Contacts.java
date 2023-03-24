package practicWhatsApp.classes;

import java.util.List;

public class Contacts {
    private String name;
    private String number;
    private List<Contacts> massage;

    public Contacts() {
    }

    public Contacts(String name, String number, List<Contacts> massage) {
        this.name = name;
        this.number = number;
        this.massage = massage;
    }

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Contacts> getMassage() {
        return massage;
    }

    public void setMassage(List<Contacts> massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", massage=" + massage +
                '}';
    }
}
