package ru.iu3.rpo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.iu3.rpo.backend.models.Museum;
import ru.iu3.rpo.backend.models.User;
import ru.iu3.rpo.backend.repositories.MuseumRepository;
import ru.iu3.rpo.backend.repositories.UserRepository;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MuseumRepository museumRepository;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {
        try {
            User newUser = userRepository.save(user);
            return new ResponseEntity<Object>(newUser, HttpStatus.OK);
        } catch (Exception ex) {
            String error;
            if (ex.getMessage().contains("null")) {
                error = "name_of_the_user_is_required";
            }
            else
                error = "undefined_error";
            Map<String, String> map = new HashMap<>();
            map.put("error", error);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/users/{id}/addmuseums")
    public ResponseEntity<Object> addMuseums(@PathVariable(value = "id") Long userId, @Validated @RequestBody Set<Museum> museums) {
        Optional<User> currentUser = userRepository.findById(userId);
        int count = 0;
        if(currentUser.isPresent()){
            User user = currentUser.get();
            for(Museum museum: museums){
                Optional<Museum> currentMuseum = museumRepository.findById(museum.id);
                if(currentMuseum.isPresent()){
                    user.addMuseum(currentMuseum.get());
                    count++;
                }
            }
            userRepository.save(user);
        }
        Map<String, String> response = new HashMap<>();
        response.put("count", String.valueOf(count));
        return ResponseEntity.ok(response);
    }
    @PostMapping("/users/{id}/removemuseums")
    public ResponseEntity<Object> removeMuseums(@PathVariable(value = "id") Long userId, @Validated @RequestBody Set<Museum> museums) {
        Optional<User> currentUser = userRepository.findById(userId);
        int count = 0;
        if(currentUser.isPresent()){
            User user = currentUser.get();
            for(Museum museum: museums){
                user.removeMuseum(museum);
                count++;
            }
            userRepository.save(user);
        }
        Map<String, String> response = new HashMap<>();
        response.put("count", String.valueOf(count));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Validated @RequestBody User userDetails) {
        User user = null;
        Optional<User> cc = userRepository.findById(userId);
        if (cc.isPresent()) {
            user = cc.get();
            user.login = userDetails.login;
            user.email = userDetails.email;
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user_not_found");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Map<String, Boolean> response = new HashMap<>();
        if (user.isPresent()) {
            userRepository.delete(user.get());
            response.put("deleted", Boolean.TRUE);
        } else {
            response.put("deleted", Boolean.FALSE);
        }
        return response;
    }
}