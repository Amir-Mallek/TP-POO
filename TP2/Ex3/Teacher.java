public class Teacher implements LibraryUser {
    private LibraryCard card;
    private Book borrowed;

    public Teacher(int id, String firstName, String lastName, String institution) {
        card = new LibraryCard(id, firstName, lastName, institution);
    }

    public void borrowBook(String title, Library library) {
        borrowed = library.getBook(title);
        library.removeBook(title);
    }

    public void returnBook(Library library) {
        if (borrowed == null) return;
        library.addBook(borrowed);
        borrowed = null;
    }

    public Book getBorrowedBook() {
        return borrowed;
    }
}
