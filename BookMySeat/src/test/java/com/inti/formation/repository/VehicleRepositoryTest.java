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

import com.inti.formation.entity.Vehicle;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VehicleRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private IVehicleRepository vehicleRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleRepositoryTest.class);
	private Vehicle dhia;
	private int dhiaId;

	@Before
	public void setUp() {
		// given
		dhia = Vehicle.builder().immatriculation("Dhia").build();
		dhiaId = (int) entityManager.persistAndGetId(dhia);
		LOGGER.info("____________ givenEntity saved ________________");
	}

	@Test
	public void givenEntityRepository_saveMethod() {

		LOGGER.info("____________Test givenEntityRepository .save Method________________");
		LOGGER.info("____________ Set newGivenEntity ________________");
		Vehicle vehicle = Vehicle.builder().immatriculation("Vincent").build();
		// when
		LOGGER.info("____________ Save givenEntity ________________");
		vehicleRepo.save(vehicle);
		// then
		LOGGER.info("____________Test equal ________________");
		assertEquals(vehicle, vehicleRepo.findById(vehicle.getId_vehicle()).get());

	}

	@Test
	public void givenEntityRepository_deleteMethod() {
		LOGGER.info("____________Test givenEntityRepository .delete Method ________________");
		// when
		LOGGER.info("____________ Delete givenEntity ________________");
		vehicleRepo.deleteById(dhia.getId_vehicle());
		// then
		LOGGER.info("____________Test Null ________________");
		assertFalse(vehicleRepo.findById(dhiaId).isPresent());

	}

	@Test
	public void givenEntityRepository_getByIdMethod() {
		LOGGER.info("____________Test givenEntityRepository .getOne Method________________");
		// when
		LOGGER.info("____________ Delete givenEntity________________");
		vehicleRepo.getOne(dhia.getId_vehicle());
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals("Dhia", vehicleRepo.getOne(dhiaId).getImmatriculation());
	}
}
