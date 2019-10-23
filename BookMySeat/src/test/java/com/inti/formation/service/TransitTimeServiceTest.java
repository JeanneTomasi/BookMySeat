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
import com.inti.formation.entity.TransitTime;
import com.inti.formation.repository.TransitTimeRepositoryTest;
import com.inti.formation.repository.ITransitTimeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class TransitTimeServiceTest {

	@InjectMocks
	private TransitTimeService transitTimeService;

	@Mock
	private ITransitTimeRepository transitTimeRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TransitTimeRepositoryTest.class);
	private TransitTime transitTime = TransitTime.builder().id_transit_time(1).transit_time("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_transitTimeRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		transitTimeService.add(transitTime);
		verify(transitTimeRepo).save(transitTime);
	}

	@Test
	public void return_transitTime_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(transitTimeRepo.save(transitTime)).thenReturn(TransitTime.builder().transit_time("Patate").build());
		assertEquals(TransitTime.builder().transit_time("Patate").build(), transitTimeService.add(transitTime));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_transitTimeRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		transitTimeService.update(transitTime);
		verify(transitTimeRepo).save(transitTime);
	}

	@Test
	public void return_transitTime_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(transitTimeRepo.save(transitTime)).thenReturn(TransitTime.builder().transit_time("Patate").build());
		assertEquals(TransitTime.builder().transit_time("Patate").build(), transitTimeService.update(transitTime));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_transitTimeRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		transitTimeService.getById(1);
		verify(transitTimeRepo).getOne(1);
	}

	@Test
	public void return_transitTime_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(transitTimeRepo.getOne(1)).thenReturn(TransitTime.builder().transit_time("Patate").build());
		assertEquals(TransitTime.builder().transit_time("Patate").build(), transitTimeService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_transitTimeRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		transitTimeService.findAll();
		verify(transitTimeRepo).findAll();
	}

	@Test
	public void return_transitTime_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<TransitTime> transitTimes = new ArrayList<TransitTime>();
		transitTimes.add(transitTime);
		transitTimes.add(TransitTime.builder().id_transit_time(2).transit_time("Ponyo").build());
		Mockito.when(transitTimeRepo.findAll()).thenReturn(transitTimes);
		assertEquals(transitTimes, transitTimeService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_transitTimeRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		transitTimeService.delete(1);
		verify(transitTimeRepo).deleteById(1);
	}

}
