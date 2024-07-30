Task 1

Problem: You are given a list of `Song` objects, where each `Song` has a `name`, `artist`, `genre`, `durationInSeconds`, and `numberOfPlays`. Your task is to implement two methods:

1. `getTopPlayedSongs(List<Song> songs, int n)`: This method should return a list of the top `n` most played songs. The songs should be sorted in descending order of `numberOfPlays`. If two songs have the same `numberOfPlays`, they should be sorted alphabetically by `name`.
    
2. `getTopPlayedArtists(List<Song> songs, int n)`: This method should return a list of the top `n` artists whose songs have been played the most. The artists should be sorted in descending order of total `numberOfPlays` of all their songs. If two artists have the same total `numberOfPlays`, they should be sorted alphabetically.
    

Example:

Input:

List<Song> songs = Arrays.asList(

    new Song("Song1", "Artist1", "Genre1", 200, 100),

    new Song("Song2", "Artist2", "Genre2", 200, 200),

    new Song("Song3", "Artist1", "Genre1", 200, 300),

    new Song("Song4", "Artist2", "Genre2", 200, 400)

);

getTopPlayedSongs(songs, 2);

getTopPlayedArtists(songs, 2);

Output:

["Song4", "Song3"]

["Artist2", "Artist1"]

Task 2

Main Topic: Stream Ordering in Stream API Operations Drawn Topic: Stream Performance

Problem: Given the same `Song` class and list of songs as in Task 1, implement two methods:

1. `getLongestSongs(List<Song> songs, int n)`: This method should return a list of the `n` longest songs (in terms of `durationInSeconds`). The songs should be sorted in descending order of `durationInSeconds`. If two songs have the same `durationInSeconds`, they should be sorted alphabetically by `name`. This method should be optimized for performance.
    
2. `getMostPopularGenres(List<Song> songs, int n)`: This method should return a list of the `n` most popular genres (in terms of total `numberOfPlays` of all songs in each genre). The genres should be sorted in descending order of total `numberOfPlays`. If two genres have the same total `numberOfPlays`, they should be sorted alphabetically. This method should be optimized for performance.
    

Example:

Input:

List<Song> songs = Arrays.asList(

    new Song("Song1", "Artist1", "Genre1", 200, 100),

    new Song("Song2", "Artist2", "Genre2", 200, 200),

    new Song("Song3", "Artist1", "Genre1", 300, 300),

    new Song("Song4", "Artist2", "Genre2", 400, 400)

);

getLongestSongs(songs, 2);

getMostPopularGenres(songs, 2);

Output:

["Song4", "Song3"]

["Genre2", "Genre1"]

Task 3

Main Topic: Stream Ordering in Stream API Operations Drawn Topic: Exception Handling

Problem: Given the same `Song` class and list of songs as in Task 1, implement two methods:

1. `getSongsByGenre(List<Song> songs, String genre)`: This method should return a list of songs in the specified genre. The songs should be sorted in descending order of `numberOfPlays`. If two songs have the same `numberOfPlays`, they should be sorted alphabetically by `name`. If the genre is null or empty, the method should throw an `IllegalArgumentException`.
    
2. `getArtistsByGenre(List<Song> songs, String genre)`: This method should return a list of artists who have songs in the specified genre. The artists should be sorted in descending order of total `numberOfPlays` of all their songs in the genre. If two artists have the same total `numberOfPlays`, they should be sorted alphabetically. If the genre is null or empty, the method should throw an `IllegalArgumentException`.
    

Example:

Input:

List<Song> songs = Arrays.asList(

    new Song("Song1", "Artist1", "Genre1", 200, 100),

    new Song("Song2", "Artist2", "Genre2", 200, 200),

    new Song("Song3", "Artist1", "Genre1", 300, 300),

    new Song("Song4", "Artist2", "Genre2", 400, 400)

);

getSongsByGenre(songs, "Genre1");

getArtistsByGenre(songs, "Genre1");

Output:

["Song3", "Song1"]

["Artist1"]

Task 4

Main Topic: Stream Ordering in Stream API Operations Drawn Topic: Parallel Stream

Problem: Given the same `Song` class and list of songs as in Task 1, implement three methods:

1. `getTopPlayedSongsParallel(List<Song> songs, int n)`: This method should return a list of the top `n` most played songs, similar to `getTopPlayedSongs` in Task 1, but it should use parallel streams for better performance.
    
2. `getTopPlayedArtistsParallel(List<Song> songs, int n)`: This method should return a list of the top `n` artists whose songs have been played the most, similar to `getTopPlayedArtists` in Task 1, but it should use parallel streams for better performance.
    
3. `getMostPopularGenresParallel(List<Song> songs, int n)`: This method should return a list of the `n` most popular genres (in terms of total `numberOfPlays` of all songs in each genre), similar to `getMostPopularGenres` in Task 2, but it should use parallel streams for better performance.
    

Example:

Input:

List<Song> songs = Arrays.asList(

    new Song("Song1", "Artist1", "Genre1", 200, 100),

    new Song("Song2", "Artist2", "Genre2", 200, 200),

    new Song("Song3", "Artist1", "Genre1", 300, 300),

    new Song("Song4", "Artist2", "Genre2", 400, 400)

);

getTopPlayedSongsParallel(songs, 2);

getTopPlayedArtistsParallel(songs, 2);

getMostPopularGenresParallel(songs, 2);

Output:

["Song4", "Song3"]

["Artist2", "Artist1"]

["Genre2", "Genre1"]