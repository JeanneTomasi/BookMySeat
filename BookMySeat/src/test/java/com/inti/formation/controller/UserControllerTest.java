package com.inti.formation.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import com.inti.formation.entity.Adress;
import com.inti.formation.entity.User;
import com.inti.formation.repository.UserRepositoryTest;
import com.inti.formation.service.UserService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class UserControllerTest {

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
	private UserController userController;

	@Mock
	private UserService userServiceToMock;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

	public UserControllerTest() {
		super();
		this.uri = "/apiUser";
	}

	private Adress adress = new Adress(1, "yolo", "youpi", 32000, "yipo");

	private User user = User.builder().id_user(1).firstName("José").adress(adress).build();

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
			String inputJson = this.mapToJson(user);
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
		Mockito.when(userServiceToMock.add(user)).thenReturn(User.builder().firstName("Patate").build());
		LOGGER.info("------------------- Test return of addEntity ----------------------");
		assertEquals(User.builder().firstName("Patate").build(), userController.add(user));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_userService_addEntity() {
		LOGGER.info("------------------ Testing the call of the good Service Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		userController.add(user);
		LOGGER.info("------------------ Verifying add Method ------------------");
		verify(userServiceToMock).add(user);
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
			userServiceToMock.add(user);
			User newUser = user;
			newUser.setFirstName("Rico");
			String inputJson = this.mapToJson(newUser);
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
		Mockito.when(userServiceToMock.update(user)).thenReturn(User.builder().firstName("Patate").build());
		LOGGER.info("------------------- Test return of updateEntity ----------------------");
		assertEquals(User.builder().firstName("Patate").build(), userController.update(user));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_userService_updateEntity() {
		LOGGER.info("------------------ Testing call of UserService.update Method ------------------");
		LOGGER.info("------------------ Saving User ------------------");
		userController.update(user);
		LOGGER.info("------------------ Verifying update Method ------------------");
		verify(userServiceToMock).update(user);
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
			userServiceToMock.add(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/get/{id}",user.getId_user()))
					.andReturn();
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
		Mockito.when(userServiceToMock.getById(1)).thenReturn(user);
		LOGGER.info("------------------- Test return of getById ----------------------");
		assertEquals(user, userController.getById(1));
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_userService_getById() {
		LOGGER.info("------------------ Testing call of UserService.getById Method ------------------");
		LOGGER.info("------------------ Call method User ------------------");
		userController.getById(1);
		LOGGER.info("------------------ Verifying getById Method ------------------");
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
			userServiceToMock.add(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc
					.perform(MockMvcRequestBuilders.get(uri + "/users").accept(MediaType.APPLICATION_JSON_VALUE))
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
		List<User> users = new ArrayList<User>();
		users.add(User.builder().name("Rico").build());
		users.add(User.builder().name("Poncho").build());
		users.add(user);
		LOGGER.info("------------------ Constructing Mockito reponse ------------------");
		Mockito.when(userServiceToMock.findAll()).thenReturn(users);
		LOGGER.info("------------------- Test return of findAll ----------------------");
		assertEquals(users, userController.findAll());
	}

	// Test de l'appel de la méthode du service

	@Test
	public void test_call_userService_findAll() {
		LOGGER.info("------------------ Testing testfindAll Method ------------------");
		userController.findAll();
		LOGGER.info("------------------ Verifying findAll Method ------------------");
		verify(userServiceToMock).findAll();
	}

	/**
	 * 
	 * TEST DELETE()
	 * 
	 */

	// Test du statut
	@Test
	public void deleteUserStatus() {
		LOGGER.info("------------------ Testing deleteUserStatus Method ------------------");

		try {
			LOGGER.info("------------------ Constructing User ------------------");
			LOGGER.info("------------------ Saving User ------------------");
			User user = User.builder().id_user(1).firstName("José").adress(adress).build();
			int userId = user.getId_user();
			userServiceToMock.add(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/delete/" + userId)).andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test du retour
	@Test
	public void deleteUser() {
		LOGGER.info("------------------ Testing deleteUser Method ------------------");

		try {
			LOGGER.info("------------------ Constructing User ------------------");
			LOGGER.info("------------------ Saving User ------------------");
			User user = User.builder().id_user(1).firstName("José").adress(adress).build();
			int userId = user.getId_user();
			userServiceToMock.add(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/delete/" + userId)).andReturn();
			LOGGER.info("------------------ Searching for User ------------------");
			User userFound = userServiceToMock.getById(userId);
			LOGGER.info("------------------ Verifying User ------------------");
			assertEquals(userFound, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test de l'appel de la méthode du service

	@Test
	public void testDeleteUser() {
		LOGGER.info("------------------ Testing testDeleteUser Method ------------------");
		LOGGER.info("------------------ Constructing User ------------------");
		User user = User.builder().id_user(1).firstName("José").adress(adress).build();
		int userId = user.getId_user();
		userServiceToMock.add(user);
		LOGGER.info("------------------ Saving User ------------------");
		userController.add(user);
		LOGGER.info("------------------ Deleting User ------------------");
		userController.delete(userId);
		LOGGER.info("------------------ Verifying delete Method ------------------");
		verify(userServiceToMock).delete(userId);
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
