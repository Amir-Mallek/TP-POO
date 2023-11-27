public interface LibraryUser {
    public void borrowBook(String title, Library library);

    public void returnBook(Library library);

    public Book getBorrowedBook();
}
