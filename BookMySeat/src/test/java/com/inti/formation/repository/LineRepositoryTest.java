package com.inti.formation.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.entity.Line;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LineRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ILineRepository lineRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(LineRepositoryTest.class);
	private Line dhia;
	private int dhiaId;

	@Before
	public void setUp() {
		// given
		dhia = Line.builder().name("Dhia").build();
		dhiaId = (int) entityManager.persistAndGetId(dhia);
		LOGGER.info("____________ givenEntity saved ________________");
	}

	@Test
	public void givenEntityRepository_saveMethod() {

		LOGGER.info("____________Test givenEntityRepository .save Method________________");
		LOGGER.info("____________ Set newGivenEntity ________________");
		Line line = Line.builder().name("Vincent").build();
		// when
		LOGGER.info("____________ Save givenEntity ________________");
		lineRepo.save(line);
		// then
		LOGGER.info("____________Test equal ________________");
		assertEquals(line, lineRepo.findById(line.getId_line()).get());

	}

	@Test
	public void givenEntityRepository_deleteMethod() {
		LOGGER.info("____________Test givenEntityRepository .delete Method ________________");
		// when
		LOGGER.info("____________ Delete givenEntity ________________");
		lineRepo.deleteById(dhia.getId_line());
		// then
		LOGGER.info("____________Test Null ________________");
		assertFalse(lineRepo.findById(dhiaId).isPresent());

	}

	@Test
	public void givenEntityRepository_getByIdMethod() {
		LOGGER.info("____________Test givenEntityRepository .getOne Method________________");
		// when
		LOGGER.info("____________ Delete givenEntity________________");
		lineRepo.getOne(dhia.getId_line());
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals("Dhia", lineRepo.getOne(dhiaId).getName());
	}

//	@Test
//	public void givenEntityRepository_findAllMethod() {
//		LOGGER.info("____________Test givenEntityRepository .findAll Method________________");
//		User bayrem = User.builder().name("Bayrem").build();
//		entityManager.persist(bayrem);
//		// when
//		LOGGER.info("____________ findAll Entities ________________");
//		List<User> users = userRepo.findAll();
//		// then
//		LOGGER.info("____________Test list lenght ________________");
//		assertNotNull(users);
//
//	}

	
}
