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
import com.inti.formation.entity.Line;
import com.inti.formation.repository.LineRepositoryTest;
import com.inti.formation.repository.ILineRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class LineServiceTest {

	@InjectMocks
	private LineService lineService;

	@Mock
	private ILineRepository lineRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(LineRepositoryTest.class);
	private Line line = Line.builder().id_line(1).name("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_lineRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		lineService.add(line);
		verify(lineRepo).save(line);
	}

	@Test
	public void return_line_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(lineRepo.save(line)).thenReturn(Line.builder().name("Patate").build());
		assertEquals(Line.builder().name("Patate").build(), lineService.add(line));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_lineRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		lineService.update(line);
		verify(lineRepo).save(line);
	}

	@Test
	public void return_line_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(lineRepo.save(line)).thenReturn(Line.builder().name("Patate").build());
		assertEquals(Line.builder().name("Patate").build(), lineService.update(line));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_lineRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		lineService.getById(1);
		verify(lineRepo).getOne(1);
	}

	@Test
	public void return_line_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(lineRepo.getOne(1)).thenReturn(Line.builder().name("Patate").build());
		assertEquals(Line.builder().name("Patate").build(), lineService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_lineRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		lineService.findAll();
		verify(lineRepo).findAll();
	}

	@Test
	public void return_line_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<Line> lines = new ArrayList<Line>();
		lines.add(line);
		lines.add(Line.builder().id_line(2).name("Ponyo").build());
		Mockito.when(lineRepo.findAll()).thenReturn(lines);
		assertEquals(lines, lineService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_lineRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		lineService.delete(1);
		verify(lineRepo).deleteById(1);
	}

}
