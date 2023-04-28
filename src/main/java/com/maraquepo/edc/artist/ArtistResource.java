//package com.maraquepo.edc.artist;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//public class ArtistResource {
//    private ArtistDaoService service;
//
//    public ArtistResource(ArtistDaoService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/api/v1/artists")
//    public List<Artist> retrieveAllArtists() {
//        return service.getAllArtists();
//    }
//
//    @GetMapping("/api/v1/artists/{id}")
//    public Artist getArtistById(@PathVariable Integer id) {
//        return service.getArtistById(id);
//    }
//
//    @PostMapping("/api/v1/artists")
//    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
//        Artist savedArtist = service.addArtist(artist);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedArtist.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/api/v1/artists/{id}")
//    public void deleteArtist(@PathVariable int id) {
//        service.deleteArtist(id);
//    }
//}
