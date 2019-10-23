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
import com.inti.formation.entity.Vehicle;
import com.inti.formation.repository.VehicleRepositoryTest;
import com.inti.formation.service.VehicleService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class VehicleControllerTest {

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
	private VehicleController vehicleController;

	@Mock
	private VehicleService vehicleServiceToMock;

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleRepositoryTest.class);

	public VehicleControllerTest() {
		super();
		this.uri = "/apiVehicle";
	}

	private Vehicle vehicle = Vehicle.builder().id_vehicle(1).immatriculation("Paco").build();

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
			String inputJson = this.mapToJson(vehicle);
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
		Mockito.when(vehicleServiceToMock.add(vehicle)).thenReturn(Vehicle.builder().immatriculation("Patate").build());
		LOGGER.info("------------------- Test return of addEntity ----------------------");
		assertEquals(Vehicle.builder().immatriculation("Patate").build(), vehicleController.add(vehicle));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_vehicleService_addEntity() {
		LOGGER.info("------------------ Testing the call of the good Service Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		vehicleController.add(vehicle);
		LOGGER.info("------------------ Verifying add Method ------------------");
		verify(vehicleServiceToMock).add(vehicle);
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
			vehicleServiceToMock.add(vehicle);
			Vehicle newVehicle = vehicle;
			newVehicle.setImmatriculation("Rico");
			String inputJson = this.mapToJson(newVehicle);
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
		Mockito.when(vehicleServiceToMock.update(vehicle))
				.thenReturn(Vehicle.builder().immatriculation("Patate").build());
		LOGGER.info("------------------- Test return of updateEntity ----------------------");
		assertEquals(Vehicle.builder().immatriculation("Patate").build(), vehicleController.update(vehicle));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_vehicleService_updateEntity() {
		LOGGER.info("------------------ Testing call of UserService.update Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		vehicleController.update(vehicle);
		LOGGER.info("------------------ Verifying update Method ------------------");
		verify(vehicleServiceToMock).update(vehicle);
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
			vehicleServiceToMock.add(vehicle);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/get/" + vehicle.getId_vehicle())
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
		Mockito.when(vehicleServiceToMock.getById(1)).thenReturn(vehicle);
		LOGGER.info("------------------- Test return of getById ----------------------");
		assertEquals(vehicle, vehicleController.getById(1));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_vehicleService_getById() {
		LOGGER.info("------------------ Testing call of UserService.getById Method ------------------");
		LOGGER.info("------------------ Call method User ------------------");
		vehicleController.getById(1);
		LOGGER.info("------------------ Verifying getById Method ------------------");
		verify(vehicleServiceToMock).getById(1);
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
			vehicleServiceToMock.add(vehicle);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.get(uri + "/vehicleectivities").accept(MediaType.APPLICATION_JSON_VALUE))
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
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(Vehicle.builder().immatriculation("Rico").build());
		vehicles.add(Vehicle.builder().immatriculation("Poncho").build());
		vehicles.add(vehicle);
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(vehicleServiceToMock.findAll()).thenReturn(vehicles);
		LOGGER.info("------------------- Test return of findAll ----------------------");
		assertEquals(vehicles, vehicleController.findAll());
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_vehicleService_findAll() {
		LOGGER.info("------------------ Testing call of UserService.findAll Method ------------------");
		vehicleController.findAll();
		LOGGER.info("------------------ Verifying findAll Method ------------------");
		verify(vehicleServiceToMock).findAll();
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
			vehicleServiceToMock.add(vehicle);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/delete/" + vehicle.getId_vehicle()))
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
//		assertNull(vehicleController.delete(1));
//	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_vehicleService_delete() {

		LOGGER.info("------------------ Testing call of UserService.delete Method ------------------");
		vehicleController.delete(1);
		LOGGER.info("------------------ Verifying delete Method ------------------");
		verify(vehicleServiceToMock).delete(1);
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
