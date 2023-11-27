public class FreeUser implements User {
    private String firstName;
    private String lastName;
    private Playlist playlist;
    final private int NB_SONG_LIMIT = 50;

    public FreeUser(String firstName, String lastName, String playlistName) {
        this.firstName = firstName;
        this.lastName = lastName;
        playlist = new Playlist(playlistName);
    }

    private void playAdd() {
        System.out.println("This is an add!");
        System.out.println("For an add free experience check out the premium deal!");
    }

    public void listen(String songName) {
        playAdd();
        Song playing = playlist.findSong(songName);
        if (playing != null) {
            playing.playSong();
        } else {
            System.out.println("Song not found :(");
        }
    }

    public void addToPlaylist(Song newSong) {
        playAdd();
        if (playlist.getNbOfSongs() >= NB_SONG_LIMIT) {
            System.out.println("You have reached the limit number of songs!");
            System.out.println("To add more check out the premium deal!");
        } else {
            playlist.addSong(newSong);
        }
    }

    public void removeFromPlaylist(String songName) {
        playAdd();
        playlist.removeSong(songName);
    }

    public void shufflePlaylist() {
        playAdd();
        playlist.shuffle();
    }
}
