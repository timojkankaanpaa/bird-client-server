package fi.vamk.tka.vybird.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.vamk.tka.vybird.entities.Observation;
import fi.vamk.tka.vybird.repositories.ObservationRepository;

@RestController
public class ObservationController {
    @Autowired
    ObservationRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/observation")
    public Observation saveObservation(@RequestBody Observation observation) {
        return repository.save(observation);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/observations")
    public Iterable<Observation> getAll() {
        return repository.findAll();
    }

}
