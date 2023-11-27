import java.util.ArrayList;

public class Library {
    private ArrayList<Book> inventory;

    public Library() {
        this.inventory = new ArrayList<Book>();
    }

    public Library(ArrayList<Book> books) {
        this.inventory = books;
    }

    public void addBook(Book newBook) {
        inventory.add(newBook);
    }

    public Book getBook(String title) {
        for (Book book : inventory) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(String title) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getTitle().equals(title)) {
                inventory.remove(i);
                return;
            }
        }
    }

    public void listBooks() {
        for (Book book : inventory) {
            System.out.println("-----------");
            book.displayInformation();
        }
    }
}
