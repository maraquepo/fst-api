package com.maraquepo.edc.jpa;

import com.maraquepo.edc.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
