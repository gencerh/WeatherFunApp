package sample;
import javafx.beans.property.SimpleStringProperty;
public class Person {
    private final SimpleStringProperty id;
    private final SimpleStringProperty UserName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty Telefonnummer;


    public Person(String id, String uName, String email, String tNumber) {
        this.UserName = new SimpleStringProperty(uName);
        this.Telefonnummer = new SimpleStringProperty(tNumber);
        this.id = new SimpleStringProperty(id);
        this.email = new SimpleStringProperty(email);
    }

    public String getUserName() {
        return UserName.get();
    }

    public void setUserName(String userName) {
        this.UserName.set(userName);
    }

    public String getTelefonnummer() {
        return Telefonnummer.get();
    }


    public void setTelefonnummer(String telefonnummer) {
        this.Telefonnummer.set(telefonnummer);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}