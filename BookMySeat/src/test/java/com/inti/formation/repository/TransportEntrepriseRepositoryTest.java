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

import com.inti.formation.entity.TransportEntreprise;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TransportEntrepriseRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ITransportEntrepriseRepository transRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(TransportEntrepriseRepositoryTest.class);
	private TransportEntreprise dhia;
	private int dhiaId;

	@Before
	public void setUp() {
		// given
		dhia = TransportEntreprise.builder().name("Dhia").build();
		dhiaId = (int) entityManager.persistAndGetId(dhia);
		LOGGER.info("____________ givenEntity saved ________________");
	}

	@Test
	public void givenEntityRepository_saveMethod() {

		LOGGER.info("____________Test givenEntityRepository .save Method________________");
		LOGGER.info("____________ Set newGivenEntity ________________");
		TransportEntreprise trans = TransportEntreprise.builder().name("Vincent").build();
		// when
		LOGGER.info("____________ Save givenEntity ________________");
		transRepo.save(trans);
		// then
		LOGGER.info("____________Test equal ________________");
		assertEquals(trans, transRepo.findById(trans.getId_transportEntreprise()).get());

	}

	@Test
	public void givenEntityRepository_deleteMethod() {
		LOGGER.info("____________Test givenEntityRepository .delete Method ________________");
		// when
		LOGGER.info("____________ Delete givenEntity ________________");
		transRepo.deleteById(dhia.getId_transportEntreprise());
		// then
		LOGGER.info("____________Test Null ________________");
		assertFalse(transRepo.findById(dhiaId).isPresent());

	}

	@Test
	public void givenEntityRepository_getByIdMethod() {
		LOGGER.info("____________Test givenEntityRepository .getOne Method________________");
		// when
		LOGGER.info("____________ Delete givenEntity________________");
		transRepo.getOne(dhia.getId_transportEntreprise());
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals("Dhia", transRepo.getOne(dhiaId).getName());
	}
}
