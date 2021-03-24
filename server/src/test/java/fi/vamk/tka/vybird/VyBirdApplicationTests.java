package fi.vamk.tka.vybird;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import fi.vamk.tka.vybird.controllers.ObservationController;
import fi.vamk.tka.vybird.entities.Observation;
import fi.vamk.tka.vybird.repositories.ObservationRepository;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class VyBirdApplicationTests {
	@Autowired
	private ObservationController controller;

	@Autowired
	ObservationRepository repository;

	@Autowired
	private MockMvc mvc;

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

	// testing controller
	@Test
	public void givenObservation_whenGetObservations_thenStatus200() throws Exception {
		// create some data to memory based database
		Observation item = new Observation();
		item.setBirdid(12);
		item.setPlace("Tampere");
		item.setTime(new Date(System.currentTimeMillis()));
		item.setUser("test");
		Observation saved = repository.save(item);
		// check that controlelr works
		// WebApplicationContext wac = new WebApplicationContext() {

		// }
		mvc.perform(get("/observations")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Tampere")));
		repository.delete(saved);
	}

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
		// create some data to memory based database
		Observation item = new Observation();
		item.setBirdid(12);
		item.setPlace("Tampere");
		item.setTime(new Date(System.currentTimeMillis()));
		item.setUser("test");
		Observation saved = repository.save(item);

		mvc.perform(get("/observations").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].place", is("Tampere")));
		repository.delete(saved);
	}

	// create test /observation/1

	// create test where you test that the server actually return JSON

	// create test /bird/1

	// create test that /birds actually return JSON data

	// update the controllers so that ane method returns either JSON or XML based on
	// client's Accept request header
}
