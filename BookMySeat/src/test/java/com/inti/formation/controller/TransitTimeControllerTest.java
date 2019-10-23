package com.inti.formation.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.io.IOException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inti.formation.BookMySeatApplication;
import com.inti.formation.entity.TransitTime;
import com.inti.formation.repository.TransitTimeRepositoryTest;
import com.inti.formation.service.TransitTimeService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class TransitTimeControllerTest {

	@Autowired
	WebApplicationContext webApplicationContext;

//	Used to mock the Web Context

	protected MockMvc mvc;

//	Used for the web service adressing. You need to initiate it in the subclasses constructors

	protected String uri;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private TransitTimeController transitController;

	@Mock
	private TransitTimeService transitServiceToMock;

	private static final Logger LOGGER = LoggerFactory.getLogger(TransitTimeRepositoryTest.class);

	public TransitTimeControllerTest() {
		super();
		this.uri = "/apiTransitTime";
	}

	private TransitTime transit = TransitTime.builder().id_transit_time(1).transit_time("Paco").build();

	/**
	 * 
	 * TEST ADD()
	 * 
	 */

	// Test du statut de .add

	@Test
	public void test_Http_addEntity() {
		LOGGER.info("------------------ Testing Http status for .add Method ------------------");
		try {
			LOGGER.info("------------------ Serializing User Object ------------------");
			String inputJson = this.mapToJson(transit);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/add")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test du retour de .add

	@Test
	public void test_return_addEntity() {
		LOGGER.info("------------------ Testing return of .add Method ------------------");
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(transitServiceToMock.add(transit))
				.thenReturn(TransitTime.builder().transit_time("Patate").build());
		LOGGER.info("------------------- Test return of addEntity ----------------------");
		assertEquals(TransitTime.builder().transit_time("Patate").build(), transitController.add(transit));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_transitService_addEntity() {
		LOGGER.info("------------------ Testing the call of the good Service Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		transitController.add(transit);
		LOGGER.info("------------------ Verifying add Method ------------------");
		verify(transitServiceToMock).add(transit);
	}

	/**
	 * 
	 * TEST UPDATE()
	 * 
	 */

	// Test du statut de .update

	@Test
	public void test_Http_updateEntity() {
		LOGGER.info("------------------ Testing Http status for .update Method ------------------");

		try {
			LOGGER.info("------------------ Serializing User Object ------------------");
			transitServiceToMock.add(transit);
			TransitTime newTransit = transit;
			newTransit.setTransit_time("Rico");
			String inputJson = this.mapToJson(newTransit);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/update")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test du retour de .update

	@Test
	public void test_return_updateEntity() {
		LOGGER.info("------------------ Testing return of .update Method ------------------");
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(transitServiceToMock.update(transit))
				.thenReturn(TransitTime.builder().transit_time("Patate").build());
		LOGGER.info("------------------- Test return of updateEntity ----------------------");
		assertEquals(TransitTime.builder().transit_time("Patate").build(), transitController.update(transit));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_transitService_updateEntity() {
		LOGGER.info("------------------ Testing call of UserService.update Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		transitController.update(transit);
		LOGGER.info("------------------ Verifying update Method ------------------");
		verify(transitServiceToMock).update(transit);
	}

	/**
	 * 
	 * TEST GET BY ID
	 * 
	 */

	// Test du statut de .getById

	@Test
	public void test_Http_getById() {
		LOGGER.info("------------------ Testing Http status for .getById Method ------------------");

		try {
			LOGGER.info("------------------ Saving User ------------------");
			transitServiceToMock.add(transit);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/get/" + transit.getId_transit_time())
					.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, mvcResult.getResponse().getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test du retour de .getById
	@Test
	public void test_return_getById() {
		LOGGER.info("------------------ Testing return of .getById Method ------------------");
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(transitServiceToMock.getById(1)).thenReturn(transit);
		LOGGER.info("------------------- Test return of getById ----------------------");
		assertEquals(transit, transitController.getById(1));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_transitService_getById() {
		LOGGER.info("------------------ Testing call of UserService.getById Method ------------------");
		LOGGER.info("------------------ Call method User ------------------");
		transitController.getById(1);
		LOGGER.info("------------------ Verifying getById Method ------------------");
		verify(transitServiceToMock).getById(1);
	}

	/**
	 * 
	 * TEST FINDALL()
	 * 
	 */

	// Test du statut de .findAll

	@Test
	public void test_Http_findAll() {

		LOGGER.info("------------------ Testing Http status for .findAll Method ------------------");

		try {
			LOGGER.info("------------------ Saving User ------------------");
			transitServiceToMock.add(transit);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc
					.perform(MockMvcRequestBuilders.get(uri + "/transitTimes").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, mvcResult.getResponse().getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test du retour de .findAll

	@Test
	public void test_return_findAll_UserList() {

		LOGGER.info("------------------ Testing return of .findAll Method ------------------");
		List<TransitTime> transits = new ArrayList<TransitTime>();
		transits.add(TransitTime.builder().transit_time("Rico").build());
		transits.add(TransitTime.builder().transit_time("Poncho").build());
		transits.add(transit);
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(transitServiceToMock.findAll()).thenReturn(transits);
		LOGGER.info("------------------- Test return of findAll ----------------------");
		assertEquals(transits, transitController.findAll());
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_transitService_findAll() {
		LOGGER.info("------------------ Testing call of UserService.findAll Method ------------------");
		transitController.findAll();
		LOGGER.info("------------------ Verifying findAll Method ------------------");
		verify(transitServiceToMock).findAll();
	}

	/**
	 * 
	 * TEST DELETE()
	 * 
	 */

	// Test du statut de .delete
	@Test
	public void test_Http_delete() {

		LOGGER.info("------------------ Testing Http status for .delete Method ------------------");

		try {
			LOGGER.info("------------------ Saving User ------------------");
			transitServiceToMock.add(transit);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc
					.perform(MockMvcRequestBuilders.delete(uri + "/delete/" + transit.getId_transit_time()))
					.andReturn();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, mvcResult.getResponse().getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	// Test du retour de .delete
//	@Test
//	public void deleteUser() {
//
//		LOGGER.info("------------------ Testing return of .delete Method ------------------");
//		LOGGER.info("------------------- Test return of findAll ----------------------");
//		assertNull(transitController.delete(1));
//	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_transitService_delete() {

		LOGGER.info("------------------ Testing call of UserService.delete Method ------------------");
		transitController.delete(1);
		LOGGER.info("------------------ Verifying delete Method ------------------");
		verify(transitServiceToMock).delete(1);
	}

	/**
	 * Serialize the given object into Json
	 * 
	 * @param obj
	 * @return String
	 * @throws JsonProcessingException
	 */
	protected final String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * Deserialize a given Json string into an object
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */

	protected final <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
