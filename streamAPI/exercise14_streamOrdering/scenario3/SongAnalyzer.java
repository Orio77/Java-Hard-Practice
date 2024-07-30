package streamAPI.exercise14_streamOrdering.scenario3;

import java.util.*;
import java.util.stream.*;


public class SongAnalyzer {
    public List<Song> getTopPlayedSongs(List<Song> songs, int n) {
        return songs.stream().sorted(Comparator.comparing(Song::getNumberOfPlays).reversed().thenComparing(Song::getName)).limit(n).toList();
    }

    public List<String> getTopPlayedArtists(List<Song> songs, int n) {
        return songs.stream().collect(Collectors.groupingBy(Song::getArtist, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public List<Song> getLongestSongs(List<Song> songs, int n) {
        return songs.stream().sorted(Comparator.comparing(Song::getDurationInSeconds)).limit(n).toList();
    }

    public List<String> getMostPopularGenres(List<Song> songs, int n) {
        return songs.stream().collect(Collectors.groupingBy(Song::getGenre, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public List<Song> getSongsByGenre(List<Song> songs, String genre) {
        return songs.stream().filter(song -> song.getGenre().matches(genre)).toList();
    }

    public List<String> getArtistsByGenre(List<Song> songs, String genre) {
        return songs.stream().map(song -> {
            if (song.getGenre() == null || song.getGenre().isEmpty()) {
                throw new IllegalArgumentException();
            }
            return song;
        }).filter(song -> song.getGenre().matches(genre)).sorted(Comparator.comparing(Song::getNumberOfPlays).thenComparing(Song::getName)).map(Song::getArtist).toList();
    }

    public List<Song> getTopPlayedSongsParallel(List<Song> songs, int n) {
        return songs.parallelStream().sorted(Comparator.comparing(Song::getNumberOfPlays).reversed().thenComparing(Song::getName)).limit(n).toList();
    }

    public List<String> getTopPlayedArtistsParallel(List<Song> songs, int n) {
        return songs.parallelStream().collect(Collectors.groupingBy(Song::getArtist, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public List<String> getMostPopularGenresParallel(List<Song> songs, int n) {
        return songs.parallelStream().collect(Collectors.groupingBy(Song::getGenre, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }
}
