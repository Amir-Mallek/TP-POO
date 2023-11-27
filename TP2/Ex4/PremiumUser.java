public class PremiumUser implements User {
    private String firstName;
    private String lastName;
    private Playlist playlist;

    public PremiumUser(String firstName, String lastName, String playlistName) {
        this.firstName = firstName;
        this.lastName = lastName;
        playlist = new Playlist(playlistName);
    }

    public void listen(String songName) {
        Song playing = playlist.findSong(songName);
        if (playing != null) {
            playing.playSong();
        } else {
            System.out.println("Song not found :(");
        }
    }

    public void addToPlaylist(Song newSong) {
        playlist.addSong(newSong);
    }

    public void removeFromPlaylist(String songName) {
        playlist.removeSong(songName);
    }

    public void shufflePlaylist() {
        playlist.shuffle();
    }
}
