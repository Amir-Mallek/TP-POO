import java.util.ArrayList;

public class Artist {
    private String name;
    private ArrayList<Album> collection;

    public Artist(String name) {
        this.name = name;
        collection = new ArrayList<Album>();
    }

    public Artist(String name, ArrayList<Album> collection) {
        this.name = name;
        this.collection = collection;
    }

    public int getCollectionSize() {
        return collection.size();
    }

    public void addAlbum(Album newAlbum) {
        collection.add(newAlbum);
    }

    public void removeAlbum(String AlbumName) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getName().equals(AlbumName)) {
                collection.remove(i);
                return;
            }
        }
    }

    public void listAlbums() {
        for (Album album : collection) {
            album.displayInformation();
        }
    }
}
