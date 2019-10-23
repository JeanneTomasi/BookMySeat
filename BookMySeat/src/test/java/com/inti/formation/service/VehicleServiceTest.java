package com.inti.formation.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.BookMySeatApplication;
import com.inti.formation.entity.Vehicle;
import com.inti.formation.repository.VehicleRepositoryTest;
import com.inti.formation.repository.IVehicleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class VehicleServiceTest {

	@InjectMocks
	private VehicleService vehicleService;

	@Mock
	private IVehicleRepository vehicleRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleRepositoryTest.class);
	private Vehicle vehicle = Vehicle.builder().id_vehicle(1).immatriculation("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_vehicleRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		vehicleService.add(vehicle);
		verify(vehicleRepo).save(vehicle);
	}

	@Test
	public void return_vehicle_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(vehicleRepo.save(vehicle)).thenReturn(Vehicle.builder().immatriculation("Patate").build());
		assertEquals(Vehicle.builder().immatriculation("Patate").build(), vehicleService.add(vehicle));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_vehicleRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		vehicleService.update(vehicle);
		verify(vehicleRepo).save(vehicle);
	}

	@Test
	public void return_vehicle_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(vehicleRepo.save(vehicle)).thenReturn(Vehicle.builder().immatriculation("Patate").build());
		assertEquals(Vehicle.builder().immatriculation("Patate").build(), vehicleService.update(vehicle));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_vehicleRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		vehicleService.getById(1);
		verify(vehicleRepo).getOne(1);
	}

	@Test
	public void return_vehicle_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(vehicleRepo.getOne(1)).thenReturn(Vehicle.builder().immatriculation("Patate").build());
		assertEquals(Vehicle.builder().immatriculation("Patate").build(), vehicleService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_vehicleRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		vehicleService.findAll();
		verify(vehicleRepo).findAll();
	}

	@Test
	public void return_vehicle_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		vehicles.add(Vehicle.builder().id_vehicle(2).immatriculation("Ponyo").build());
		Mockito.when(vehicleRepo.findAll()).thenReturn(vehicles);
		assertEquals(vehicles, vehicleService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_vehicleRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		vehicleService.delete(1);
		verify(vehicleRepo).deleteById(1);
	}

}
