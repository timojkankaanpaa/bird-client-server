package fi.vamk.tka.vybird.repositories;

import org.springframework.data.repository.CrudRepository;

import fi.vamk.tka.vybird.entities.Observation;

public interface ObservationRepository extends CrudRepository<Observation, Integer> {

}
