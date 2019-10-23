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
import com.inti.formation.entity.SeatReservation;
import com.inti.formation.repository.SeatReservationRepositoryTest;
import com.inti.formation.repository.ISeatReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class SeatReservationServiceTest {

	@InjectMocks
	private SeatReservationService seatReservationService;

	@Mock
	private ISeatReservationRepository seatReservationRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeatReservationRepositoryTest.class);
	private SeatReservation seatReservation = SeatReservation.builder().id_seat_reservation(1).starting_time("Piano")
			.build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_seatReservationRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		seatReservationService.add(seatReservation);
		verify(seatReservationRepo).save(seatReservation);
	}

	@Test
	public void return_seatReservation_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(seatReservationRepo.save(seatReservation))
				.thenReturn(SeatReservation.builder().starting_time("Patate").build());
		assertEquals(SeatReservation.builder().starting_time("Patate").build(),
				seatReservationService.add(seatReservation));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_seatReservationRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		seatReservationService.update(seatReservation);
		verify(seatReservationRepo).save(seatReservation);
	}

	@Test
	public void return_seatReservation_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(seatReservationRepo.save(seatReservation))
				.thenReturn(SeatReservation.builder().starting_time("Patate").build());
		assertEquals(SeatReservation.builder().starting_time("Patate").build(),
				seatReservationService.update(seatReservation));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_seatReservationRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		seatReservationService.getById(1);
		verify(seatReservationRepo).getOne(1);
	}

	@Test
	public void return_seatReservation_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(seatReservationRepo.getOne(1))
				.thenReturn(SeatReservation.builder().starting_time("Patate").build());
		assertEquals(SeatReservation.builder().starting_time("Patate").build(), seatReservationService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_seatReservationRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		seatReservationService.findAll();
		verify(seatReservationRepo).findAll();
	}

	@Test
	public void return_seatReservation_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<SeatReservation> seatReservations = new ArrayList<SeatReservation>();
		seatReservations.add(seatReservation);
		seatReservations.add(SeatReservation.builder().id_seat_reservation(2).starting_time("Ponyo").build());
		Mockito.when(seatReservationRepo.findAll()).thenReturn(seatReservations);
		assertEquals(seatReservations, seatReservationService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_seatReservationRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		seatReservationService.delete(1);
		verify(seatReservationRepo).deleteById(1);
	}

}
