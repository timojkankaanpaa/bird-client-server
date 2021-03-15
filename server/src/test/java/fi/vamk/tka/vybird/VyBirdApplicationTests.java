package fi.vamk.tka.vybird;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.vamk.tka.vybird.controllers.BirdController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VyBirdApplicationTests {
	@Autowired
	private BirdController controller;

	@Test
	void contextLoads() {
	}

	@Test
	public void checkThatControllerLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
