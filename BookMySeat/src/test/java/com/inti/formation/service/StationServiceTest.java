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
import com.inti.formation.entity.Station;
import com.inti.formation.repository.StationRepositoryTest;
import com.inti.formation.repository.IStationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class StationServiceTest {

	@InjectMocks
	private StationService stationService;

	@Mock
	private IStationRepository stationRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(StationRepositoryTest.class);
	private Station station = Station.builder().id_station(1).name("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_stationRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		stationService.add(station);
		verify(stationRepo).save(station);
	}

	@Test
	public void return_station_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(stationRepo.save(station)).thenReturn(Station.builder().name("Patate").build());
		assertEquals(Station.builder().name("Patate").build(), stationService.add(station));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_stationRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		stationService.update(station);
		verify(stationRepo).save(station);
	}

	@Test
	public void return_station_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(stationRepo.save(station)).thenReturn(Station.builder().name("Patate").build());
		assertEquals(Station.builder().name("Patate").build(), stationService.update(station));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_stationRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		stationService.getById(1);
		verify(stationRepo).getOne(1);
	}

	@Test
	public void return_station_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(stationRepo.getOne(1)).thenReturn(Station.builder().name("Patate").build());
		assertEquals(Station.builder().name("Patate").build(), stationService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_stationRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		stationService.findAll();
		verify(stationRepo).findAll();
	}

	@Test
	public void return_station_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<Station> stations = new ArrayList<Station>();
		stations.add(station);
		stations.add(Station.builder().id_station(2).name("Ponyo").build());
		Mockito.when(stationRepo.findAll()).thenReturn(stations);
		assertEquals(stations, stationService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_stationRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		stationService.delete(1);
		verify(stationRepo).deleteById(1);
	}

}
