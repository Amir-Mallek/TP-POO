public class LibraryCard {
    private int id;
    private String firstName;
    private String lastName;
    private String institution;

    public LibraryCard(int id, String firstName, String lastName, String institution) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.institution = institution;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
