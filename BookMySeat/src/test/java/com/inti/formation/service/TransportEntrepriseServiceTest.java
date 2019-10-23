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
import com.inti.formation.entity.TransportEntreprise;
import com.inti.formation.repository.ITransportEntrepriseRepository;
import com.inti.formation.repository.TransitTimeRepositoryTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class TransportEntrepriseServiceTest {

	@InjectMocks
	private TransportEntrepriseService entrepriseService;

	@Mock
	private ITransportEntrepriseRepository entrepriseRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TransitTimeRepositoryTest.class);
	private TransportEntreprise transportEntreprise = TransportEntreprise.builder().id_transportEntreprise(1)
			.name("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Testing .add method
	 */
	@Test
	public void call_entrepriseRepo_add_method() {
		LOGGER.info("______________ Test of .add Method call _______________");
		entrepriseService.add(transportEntreprise);
		verify(entrepriseRepo).save(transportEntreprise);
	}

	@Test
	public void return_transportEntreprise_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(entrepriseRepo.save(transportEntreprise))
				.thenReturn(TransportEntreprise.builder().name("Patate").build());
		assertEquals(TransportEntreprise.builder().name("Patate").build(), entrepriseService.add(transportEntreprise));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_entrepriseRepo_update_method() {
		LOGGER.info("______________ Test of .update Method call _______________");
		entrepriseService.update(transportEntreprise);
		verify(entrepriseRepo).save(transportEntreprise);
	}

	@Test
	public void return_transportEntreprise_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(entrepriseRepo.save(transportEntreprise))
				.thenReturn(TransportEntreprise.builder().name("Patate").build());
		assertEquals(TransportEntreprise.builder().name("Patate").build(),
				entrepriseService.update(transportEntreprise));
	}

	/**
	 * Testing .getById method
	 */
	@Test
	public void call_entrepriseRepo_getById_method() {
		LOGGER.info("______________ Test of .getById Method call _______________");
		entrepriseService.getById(1);
		verify(entrepriseRepo).getOne(1);
	}

	@Test
	public void return_transportEntreprise_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(entrepriseRepo.getOne(1)).thenReturn(TransportEntreprise.builder().name("Patate").build());
		assertEquals(TransportEntreprise.builder().name("Patate").build(), entrepriseService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_entrepriseRepo_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method call _______________");
		entrepriseService.findAll();
		verify(entrepriseRepo).findAll();
	}

	@Test
	public void return_transportEntreprise_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<TransportEntreprise> transportEntreprises = new ArrayList<TransportEntreprise>();
		transportEntreprises.add(transportEntreprise);
		transportEntreprises.add(TransportEntreprise.builder().id_transportEntreprise(2).name("Ponyo").build());
		Mockito.when(entrepriseRepo.findAll()).thenReturn(transportEntreprises);
		assertEquals(transportEntreprises, entrepriseService.findAll());
	}

	/**
	 * Testing .delete method
	 */
	@Test
	public void call_entrepriseRepo_delete_method() {
		LOGGER.info("______________ Test of .delete Method call _______________");
		entrepriseService.delete(1);
		verify(entrepriseRepo).deleteById(1);
	}

}
