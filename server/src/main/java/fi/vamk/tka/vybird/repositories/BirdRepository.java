package fi.vamk.tka.vybird.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.vamk.tka.vybird.entities.Bird;

public interface BirdRepository extends CrudRepository<Bird, Integer> {
    List<Bird> findByOrderByEnglish(); // ...ByFinnish, ...BySwedish
}
