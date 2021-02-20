package fi.vamk.tka.vybird.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.vamk.tka.vybird.entities.Bird;
import fi.vamk.tka.vybird.repositories.BirdRepository;

@RestController
public class BirdController {
    @Autowired
    BirdRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/birds")
    public Iterable<Bird> getAll() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/birds_fi")
    public Iterable<Bird> getAllFinnish() {
        return repository.findByOrderByFinnish();
    }

}
