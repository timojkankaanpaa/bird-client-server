package fi.vamk.tka.vybird;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.vamk.tka.vybird.controllers.ObservationController;
import fi.vamk.tka.vybird.entities.Observation;
import fi.vamk.tka.vybird.repositories.ObservationRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
class VyBirdApplicationTests {
	@Autowired
	private ObservationController controller;

	@Autowired
	ObservationRepository repository;

	@Test
	void contextLoads() {
	}

	// Testing that controller can be run
	@Test
	public void checkThatControllerLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void whenFindByName_thenReturnPartner() {
		// given
		Observation item = new Observation();
		item.setBirdid(12);
		item.setPlace("Tampere");
		item.setTime(new Date(System.currentTimeMillis()));
		item.setUser("test");
		Observation saved = repository.save(item);

		// when
		Optional<Observation> found = repository.findById(saved.getId());

		// then (note that database return Optional[item] so need to .get the object)
		assertThat(found.get().toString()).isEqualTo(saved.toString());
		// remove the data from persistant database
		repository.delete(saved);
	}

	// Check that you can inser a new bird

	// Check that birds-table has 248 birds

	// Check (and improve) that you can fetch the birds also sorted on Finnish name

}
