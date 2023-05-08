package com.maraquepo.edc.artist;

import com.maraquepo.edc.exception.ResourceNotFoundException;
import com.maraquepo.edc.jpa.ArtistRepository;
import com.maraquepo.edc.jpa.PerformanceRepository;
import com.maraquepo.edc.performance.Performance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ArtistJPAResource {
    private ArtistRepository repository;

    private PerformanceRepository performanceRepository;
    private ArtistDaoService service;

    public ArtistJPAResource(ArtistRepository repository, ArtistDaoService service, PerformanceRepository performanceRepository) {
        this.repository = repository;
        this.service = service;
        this.performanceRepository = performanceRepository;
    }

    @GetMapping("/api/v1/artists")
    public List<Artist> retrieveAllArtists() {
        return repository.findAll();
    }

    @GetMapping("/api/v1/performances")
    public List<Performance> retrieveAllPerformances() {
        return performanceRepository.findAll();
    }



    @GetMapping("/api/v1/artists/{id}")
    public Optional<Artist> getArtistById(@PathVariable Integer id) {
        Optional<Artist> artist = repository.findById(id);

        return artist;
    }

    @PostMapping("/api/v1/artists")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist savedArtist = repository.save(artist);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedArtist.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/api/v1/artists/{id}")
    public void deleteArtist(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/api/v1/artists/{id}/performances")
    public List<Performance> retrievePerformancesForArtist(@PathVariable int id) {
        Optional<Artist> artist = repository.findById(id);

        return artist.get().getPerformances();
    }

    @PostMapping("/api/v1/artists/{id}/performances")
    public ResponseEntity<Object> createPerformanceForUser(@PathVariable int id, @RequestBody Performance performance) {
        Optional<Artist> artist = repository.findById(id);

        performance.setArtist(artist.get());

        Performance savedPerformance = performanceRepository.save(performance);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPerformance.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/api/v1/performances/{performanceId}")
    public ResponseEntity<Object> updatePerformance(@PathVariable Integer performanceId, @RequestBody Performance updatedPerformance) {
        Optional<Performance> performanceOptional = performanceRepository.findById(performanceId);

        if (!performanceOptional.isPresent()) {
            throw new ResourceNotFoundException("Performance not found with ID: " + performanceId);
        }

        Performance performance = performanceOptional.get();

        if (updatedPerformance.getStartTime() != null) {
            performance.setStartTime(updatedPerformance.getStartTime());
        }

        if (updatedPerformance.getEndtime() != null) {
            performance.setEndtime(updatedPerformance.getEndtime());
        }

        performanceRepository.save(performance);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/v1/performances/{performanceId}")
    public ResponseEntity<Performance> getPerformanceById(@PathVariable Integer performanceId) {
        Optional<Performance> performanceOptional = performanceRepository.findById(performanceId);
        if (performanceOptional.isPresent()) {
            Performance performance = performanceOptional.get();
            return ResponseEntity.ok(performance);
        } else {
            throw new ResourceNotFoundException("Performance not found with ID: " + performanceId);
        }
    }

}
