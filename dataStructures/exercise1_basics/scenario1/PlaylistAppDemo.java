package dataStructures.exercise1_basics.scenario1;

public class PlaylistAppDemo {
    public static void main(String[] args) {
        
        //generating song and a playlist
        Song song1 = new Song("Ed Sheeran", "Perfect", 182);
        Song song2 = new Song("Taylor Swift", "Love Story", 230);
        Song song3 = new Song("Bruno Mars", "Just The Way You Are", 215);
        Song song4 = new Song("Adele", "Hello", 295);
        Song song5 = new Song("Justin Bieber", "Sorry", 200);
        Song song6 = new Song("Maroon 5", "Sugar", 235);
        Song song7 = new Song("Coldplay", "Yellow", 266);
        Song song8 = new Song("Rihanna", "Diamonds", 220);
        Song song9 = new Song("Beyonce", "Halo", 225);
        Song song10 = new Song("Katy Perry", "Roar", 210);

        Playlist playlist1 = new Playlist("Pop Songs");

        //adding song to the playlist
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist1.addSong(song3);
        playlist1.addSong(song4);
        playlist1.addSong(song5);
        playlist1.addSong(song6);
        playlist1.addSong(song7);
        playlist1.addSong(song8);
        playlist1.addSong(song9);
        playlist1.addSong(song10);
        System.out.println(playlist1);
        System.out.println();

        //checking if remove methods work
        playlist1.removeSong(2);
        System.out.println(playlist1);
        System.out.println();
        playlist1.removeSong("Hello");
        playlist1.removeSong("I am not Sorry");
        System.out.println(playlist1);
        System.out.println();

        //checking if shuffle method works
        playlist1.shuffle();
        System.out.println(playlist1);
    }
}
