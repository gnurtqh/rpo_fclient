package ru.iu3.rpo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.iu3.rpo.backend.models.Artist;
import ru.iu3.rpo.backend.models.Country;
import ru.iu3.rpo.backend.repositories.ArtistRepository;
import ru.iu3.rpo.backend.repositories.CountryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    CountryRepository countryRepository;
    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @PostMapping("/artists")
    public ResponseEntity<Object> createArtist(@Validated @RequestBody Artist artist) {
        try {
            Optional<Country> currentCountry = countryRepository.findById(artist.country.id);
            if(currentCountry.isPresent()){
                artist.country = currentCountry.get();
            }
            Artist newArtist = artistRepository.save(artist);
            return new ResponseEntity<Object>(newArtist, HttpStatus.OK);
        } catch (Exception ex) {
            String error;
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("null")) {

                error = "name_of_the_artist_is_required";
            }
            else
                error = "undefined_error";
            Map<String, String> map = new HashMap<>();
            map.put("error", error);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @PutMapping("/artists/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") Long artistId, @Validated @RequestBody Artist artistDetails) {
        Artist artist = null;
        Optional<Artist> cc = artistRepository.findById(artistId);
        if (cc.isPresent()) {
            artist = cc.get();
            artist.name = artistDetails.name;
            artist.country = artistDetails.country;
            artist.century = artistDetails.century;
            artistRepository.save(artist);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "artist_not_found");
        }
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping("/artists/{id}")
    public Map<String, Boolean> deleteArtist(@PathVariable(value = "id") Long artistId) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        Map<String, Boolean> response = new HashMap<>();
        if (artist.isPresent()) {
            artistRepository.delete(artist.get());
            response.put("deleted", Boolean.TRUE);
        } else {
            response.put("deleted", Boolean.FALSE);
        }
        return response;
    }
}