import java.util.ArrayList;
import java.util.Collections;

public class Playlist extends Album {
    public Playlist(String name) {
        super(name);
    }

    public Song findSong(String songName) {
        for (Song song : super.collection) {
            if (song.getName().equals(songName)) {
                return song;
            }
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(collection);
    }
}
