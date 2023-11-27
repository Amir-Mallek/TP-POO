import java.util.ArrayList;

public class Album {
    private String name;
    protected ArrayList<Song> collection;

    public Album(String name) {
        this.name = name;
        collection = new ArrayList<Song>();
    }

    public Album(String name, ArrayList<Song> collection) {
        this.name = name;
        this.collection = collection;
    }

    public String getName() {
        return name;
    }

    public int getNbOfSongs() {
        return collection.size();
    }

    public void addSong(Song newSong) {
        collection.add(newSong);
    }

    public void removeSong(String name) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getName().equals(name)) {
                collection.remove(i);
                return;
            }
        }
    }

    public void listSongs() {
        for (Song song : collection) {
            song.displayInformation();
        }
    }

    public void displayInformation() {
        System.out.println("name=" + name + ", nbOfSongs=" + collection.size());
    }
}
