package com.maraquepo.edc.artist;

import com.maraquepo.edc.performance.Performance;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class ArtistDaoService {

    private static List<Artist> artists = new ArrayList<>();


    private static int artistId = 0;

    static {
        artists.add(new Artist(++artistId, "Skrillex", null));
        artists.add(new Artist(++artistId, "Diplo", null));
        artists.add(new Artist(++artistId, "Yellow Claw", null));
    }

    public List<Artist> getAllArtists() {
        return artists;
    }

    public Artist getArtistById(int id) {
        Predicate<? super Artist> predicate = artist -> artist.getId().equals(id);
        return artists.stream().filter(predicate).findFirst().orElse(null);
    }

    public Artist addArtist(Artist artist) {
        artist.setId(++artistId);
        artists.add(artist);
        return artist;
    }

    public void deleteArtist(int id) {
        artists.removeIf(artist -> artist.getId() == id);
    }

    public void addPerformance(int artistId, Performance performance) {
        Optional<Artist> artist = Optional.ofNullable(getArtistById(artistId));
        artist.ifPresent(a -> a.getPerformances().add(performance));
    }

    public void removePerformance(int artistId, int performanceId) {
        Optional<Artist> artist = Optional.ofNullable(getArtistById(artistId));
        artist.ifPresent(a -> a.getPerformances().removeIf(p -> p.getId() == performanceId));
    }


}
