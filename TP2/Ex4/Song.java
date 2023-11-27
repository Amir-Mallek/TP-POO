public class Song {
    private String name;
    private String prodComp;
    private String genre;
    private int releaseYear;
    private int lengthInSecs;

    public Song(String name, String prodComp, String genre, int releaseYear, int lengthInSecs) {
        this.name = name;
        this.prodComp = prodComp;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.lengthInSecs = lengthInSecs;
    }

    void playSong() {
        System.out.println(name + " is playing!");
    }

    public String getName() {
        return name;
    }

    public String getProdComp() {
        return prodComp;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getLengthInSecs() {
        return lengthInSecs;
    }

    public void displayInformation() {
        System.out.print("name=" + name);
        System.out.print(", prodComp=" + prodComp);
        System.out.print(", genre=" + genre);
        System.out.print(", releaseYear=" + releaseYear);
        System.out.println(", lengthInSecs=" + lengthInSecs);
    }
}
