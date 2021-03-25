package ru.iu3.rpo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.iu3.rpo.backend.models.Museum;
import ru.iu3.rpo.backend.repositories.MuseumRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MuseumController {
    @Autowired
    MuseumRepository museumRepository;

    @GetMapping("/museums")
    public List<Museum> getAllMuseums() {
        return museumRepository.findAll();
    }

    @PostMapping("/museums")
    public ResponseEntity<Object> createMuseum(@Validated @RequestBody Museum museum) {
        try {
            Museum newMuseum = museumRepository.save(museum);
            return new ResponseEntity<Object>(newMuseum, HttpStatus.OK);
        } catch (Exception ex) {
            String error;
            if (ex.getMessage().contains("null"))
                error = "name_of_the_museum_is_required";
            else
                error = "undefined_error";
            Map<String, String> map = new HashMap<>();
            map.put("error", error);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @PutMapping("/museums/{id}")
    public ResponseEntity<Museum> updateMuseum(@PathVariable(value = "id") Long museumId, @Validated @RequestBody Museum museumDetails) {
        Museum museum = null;
        Optional<Museum> cc = museumRepository.findById(museumId);
        if (cc.isPresent()) {
            museum = cc.get();
            System.out.println(museum);
            museum.name = museumDetails.name;
            museum.location = museumDetails.location;
            museumRepository.save(museum);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "museum_not_found");
        }
        return ResponseEntity.ok(museum);
    }

    @DeleteMapping("/museums/{id}")
    public Map<String, Boolean> deleteMuseum(@PathVariable(value = "id") Long museumId) {
        Optional<Museum> museum = museumRepository.findById(museumId);
        Map<String, Boolean> response = new HashMap<>();
        if (museum.isPresent()) {
            museumRepository.delete(museum.get());
            response.put("deleted", Boolean.TRUE);
        } else {
            response.put("deleted", Boolean.FALSE);
        }
        return response;
    }
}