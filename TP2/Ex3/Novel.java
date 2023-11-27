public class Novel extends Book {
    private int nbOfPages;

    public Novel(String title, String author, int yearOfPublication, int nbOfPages) {
        super(title, author, yearOfPublication);
        this.nbOfPages = nbOfPages;
    }

    public int getNbOfPages() {
        return nbOfPages;
    }

    public void displayInformation() {
        super.displayInformation();
        System.out.println("Number of pages: " + nbOfPages);
    }
}
