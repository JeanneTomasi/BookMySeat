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

import com.inti.formation.entity.Seat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SeatRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ISeatRepository seatRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(SeatRepositoryTest.class);
	private Seat dhia;
	private int dhiaId;

	@Before
	public void setUp() {
		// given
		dhia = Seat.builder().placement("Dhia").build();
		dhiaId = (int) entityManager.persistAndGetId(dhia);
		LOGGER.info("____________ givenEntity saved ________________");
	}

	@Test
	public void givenEntityRepository_saveMethod() {

		LOGGER.info("____________Test givenEntityRepository .save Method________________");
		LOGGER.info("____________ Set newGivenEntity ________________");
		Seat seat = Seat.builder().placement("Vincent").build();
		// when
		LOGGER.info("____________ Save givenEntity ________________");
		seatRepo.save(seat);
		// then
		LOGGER.info("____________Test equal ________________");
		assertEquals(seat, seatRepo.findById(seat.getId_seat()).get());

	}

	@Test
	public void givenEntityRepository_deleteMethod() {
		LOGGER.info("____________Test givenEntityRepository .delete Method ________________");
		// when
		LOGGER.info("____________ Delete givenEntity ________________");
		seatRepo.deleteById(dhia.getId_seat());
		// then
		LOGGER.info("____________Test Null ________________");
		assertFalse(seatRepo.findById(dhiaId).isPresent());

	}

	@Test
	public void givenEntityRepository_getByIdMethod() {
		LOGGER.info("____________Test givenEntityRepository .getOne Method________________");
		// when
		LOGGER.info("____________ Delete givenEntity________________");
		seatRepo.getOne(dhia.getId_seat());
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals("Dhia", seatRepo.getOne(dhiaId).getPlacement());
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
