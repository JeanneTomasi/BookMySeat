package com.inti.formation.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.inti.formation.entity.Adress;
import com.inti.formation.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private IUserRepository userRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);
	private User dhia;
	private int dhiaId;

	@Before
	public void setUp() {
		// given
		dhia = User.builder().name("Dhia").build();
		dhiaId = (int) entityManager.persistAndGetId(dhia);
		LOGGER.info("____________ givenEntity saved ________________");
	}

	@Test
	public void givenEntityRepository_saveMethod() {

		LOGGER.info("____________Test givenEntityRepository .save Method________________");
		LOGGER.info("____________ Set newGivenEntity ________________");
		User user = User.builder().name("Vincent").adress(new Adress(27, "bd Eugène Deruelle", "Lyon", 69003, "France"))
				.dateDeNaissance(LocalDate.of(1988, Month.MARCH, 22)).build();
		// when
		LOGGER.info("____________ Save givenEntity ________________");
		userRepo.save(user);
		// then
		LOGGER.info("____________Test equal ________________");
		assertEquals(user, userRepo.findById(user.getId_user()).get());

	}

	@Test
	public void givenEntityRepository_deleteMethod() {
		LOGGER.info("____________Test givenEntityRepository .delete Method ________________");
		// when
		LOGGER.info("____________ Delete givenEntity ________________");
		userRepo.deleteById(dhia.getId_user());
		// then
		LOGGER.info("____________Test Null ________________");
		assertFalse(userRepo.findById(dhiaId).isPresent());

	}

	@Test
	public void givenEntityRepository_getByIdMethod() {
		LOGGER.info("____________Test givenEntityRepository .getOne Method________________");
		// when
		LOGGER.info("____________ Delete givenEntity________________");
		userRepo.getOne(dhia.getId_user());
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals("Dhia", userRepo.getOne(dhiaId).getName());
	}

	@Test
	public void givenEntityRepository_findAllMethod() {
		LOGGER.info("____________Test givenEntityRepository .findAll Method________________");
		// when
		LOGGER.info("____________ findAll Entities ________________");
		List<User> users = userRepo.findAll();
		// then
		LOGGER.info("____________Test list lenght ________________");
		int userNumber = users.size();
		assertTrue(userNumber > 0);

	}

}
