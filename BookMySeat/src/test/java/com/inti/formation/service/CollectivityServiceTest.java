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
import com.inti.formation.entity.Collectivity;
import com.inti.formation.repository.CollectivityRepositoryTest;
import com.inti.formation.repository.ICollectivityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class CollectivityServiceTest {

	@InjectMocks
	private CollectivityService collectivityService;

	@Mock
	private ICollectivityRepository collectivityRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectivityRepositoryTest.class);
	private Collectivity collectivity = Collectivity.builder().id_collectivity(1).name("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_collectivityRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		collectivityService.add(collectivity);
		verify(collectivityRepo).save(collectivity);
	}

	@Test
	public void return_collectivity_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(collectivityRepo.save(collectivity)).thenReturn(Collectivity.builder().name("Patate").build());
		assertEquals(Collectivity.builder().name("Patate").build(), collectivityService.add(collectivity));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_collectivityRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		collectivityService.update(collectivity);
		verify(collectivityRepo).save(collectivity);
	}

	@Test
	public void return_collectivity_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(collectivityRepo.save(collectivity)).thenReturn(Collectivity.builder().name("Patate").build());
		assertEquals(Collectivity.builder().name("Patate").build(), collectivityService.update(collectivity));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_collectivityRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		collectivityService.getById(1);
		verify(collectivityRepo).getOne(1);
	}

	@Test
	public void return_collectivity_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(collectivityRepo.getOne(1)).thenReturn(Collectivity.builder().name("Patate").build());
		assertEquals(Collectivity.builder().name("Patate").build(), collectivityService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_collectivityRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		collectivityService.findAll();
		verify(collectivityRepo).findAll();
	}

	@Test
	public void return_collectivity_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<Collectivity> collectivitys = new ArrayList<Collectivity>();
		collectivitys.add(collectivity);
		collectivitys.add(Collectivity.builder().id_collectivity(2).name("Ponyo").build());
		Mockito.when(collectivityRepo.findAll()).thenReturn(collectivitys);
		assertEquals(collectivitys, collectivityService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_collectivityRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		collectivityService.delete(1);
		verify(collectivityRepo).deleteById(1);
	}

}
