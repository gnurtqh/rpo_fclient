package ru.iu3.rpo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.iu3.rpo.backend.models.Museum;
import ru.iu3.rpo.backend.models.Painting;
import ru.iu3.rpo.backend.repositories.MuseumRepository;
import ru.iu3.rpo.backend.repositories.PaintingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PaintingController {
    @Autowired
    PaintingRepository paintingRepository;

    @GetMapping("/paintings")
    public List<Painting> getAllMuseums() {
        return paintingRepository.findAll();
    }

    @PostMapping("/paintings")
    public ResponseEntity<Object> createMuseum(@Validated @RequestBody Painting painting) {
        try {
            Painting newPainting = paintingRepository.save(painting);
            return new ResponseEntity<Object>(newPainting, HttpStatus.OK);
        } catch (Exception ex) {
            String error;
            if (ex.getMessage().contains("null"))
                error = "name_of_the_painting_is_required";
            else
                error = "undefined_error";
            Map<String, String> map = new HashMap<>();
            map.put("error", error);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @PutMapping("/paintings/{id}")
    public ResponseEntity<Painting> updatePainting(@PathVariable(value = "id") Long museumId, @Validated @RequestBody Painting paintingDetails) {
        Painting painting = null;
        Optional<Painting> cc = paintingRepository.findById(museumId);
        if (cc.isPresent()) {
            painting = cc.get();
            painting.name = paintingDetails.name;
            painting.artistid = paintingDetails.artistid;
            painting.museumid = paintingDetails.museumid;
            painting.year = paintingDetails.year;
            paintingRepository.save(painting);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "painting_not_found");
        }
        return ResponseEntity.ok(painting);
    }

    @DeleteMapping("/paintings/{id}")
    public Map<String, Boolean> deleteMuseum(@PathVariable(value = "id") Long paintingId) {
        Optional<Painting> painting = paintingRepository.findById(paintingId);
        Map<String, Boolean> response = new HashMap<>();
        if (painting.isPresent()) {
            paintingRepository.delete(painting.get());
            response.put("deleted", Boolean.TRUE);
        } else {
            response.put("deleted", Boolean.FALSE);
        }
        return response;
    }
}