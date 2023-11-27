public class Textbook extends Book {
    private String topic;

    public Textbook(String title, String author, int yearOfPublication, String topic) {
        super(title, author, yearOfPublication);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void displayInformation() {
        super.displayInformation();
        System.out.println("Topic: " + topic);
    }
}
