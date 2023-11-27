public interface User {
    public void listen(String songName);

    public void addToPlaylist(Song newSong);

    public void removeFromPlaylist(String songName);

    public void shufflePlaylist();
}
