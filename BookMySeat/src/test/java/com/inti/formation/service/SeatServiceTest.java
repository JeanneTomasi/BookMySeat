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
import com.inti.formation.entity.Seat;
import com.inti.formation.repository.ISeatRepository;
import com.inti.formation.repository.SeatRepositoryTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class SeatServiceTest {

	@InjectMocks
	private SeatService seatService;

	@Mock
	private ISeatRepository seatRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeatRepositoryTest.class);
	private Seat seat = Seat.builder().id_seat(1).placement("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_seatRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		seatService.add(seat);
		verify(seatRepo).save(seat);
	}

	@Test
	public void return_seat_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(seatRepo.save(seat)).thenReturn(Seat.builder().placement("Patate").build());
		assertEquals(Seat.builder().placement("Patate").build(), seatService.add(seat));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_seatRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		seatService.update(seat);
		verify(seatRepo).save(seat);
	}

	@Test
	public void return_seat_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(seatRepo.save(seat)).thenReturn(Seat.builder().placement("Patate").build());
		assertEquals(Seat.builder().placement("Patate").build(), seatService.update(seat));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_seatRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		seatService.getById(1);
		verify(seatRepo).getOne(1);
	}

	@Test
	public void return_seat_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(seatRepo.getOne(1)).thenReturn(Seat.builder().placement("Patate").build());
		assertEquals(Seat.builder().placement("Patate").build(), seatService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_seatRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		seatService.findAll();
		verify(seatRepo).findAll();
	}

	@Test
	public void return_seat_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<Seat> seats = new ArrayList<Seat>();
		seats.add(seat);
		seats.add(Seat.builder().id_seat(2).placement("Ponyo").build());
		Mockito.when(seatRepo.findAll()).thenReturn(seats);
		assertEquals(seats, seatService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_seatRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		seatService.delete(1);
		verify(seatRepo).deleteById(1);
	}

}
