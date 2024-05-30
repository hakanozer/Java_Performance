package perfom_object;

public class Profile {

    String name = "Mehmet";

    public String nameSurname() {
        Phone phone = new Phone();
        String surname = "Bilmem";
        return name + " " + surname;
    }

    public int nameCount() {
        return name.length();
    }

}
