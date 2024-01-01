public class Club {
    private final String name;
    private final String description;

    public Club(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return name + " - " + description;
    }
}
