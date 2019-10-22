package com.inti.formation.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
import com.inti.formation.entity.User;
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

	@Autowired
	private UserService userService;

	@Mock
	private UserService userServiceToMock;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

	public UserControllerTest() {
		super();
		this.uri = "/apiUser";
	}

	
	/**
	 * 
	 * TEST FINDALL()
	 * 
	 */
	
	//Test du statut
	
	@Test
	public void testfindAllStatus() {
		MvcResult mvcResult;
		try {
			LOGGER.info("------------------ Testing findAllStatus Method ------------------");
			LOGGER.info("------------------ Constructing User ------------------");
			LOGGER.info("------------------ Saving User ------------------");
			userService.add(User.builder().firstName("José").build());
			LOGGER.info("------------------ Mocking Context Webservice ------------------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/users").
					accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test du retour
	
	@Test
	public void findAllUserList() {
		MvcResult mvcResult;
		try {
			LOGGER.info("------------------ Testing findAllUserList Method ------------------");
			LOGGER.info("------------------ Constructing User ------------------");
			LOGGER.info("------------------ Saving User ------------------");
			userService.add(User.builder().firstName("José").build());
			LOGGER.info("------------------ Mocking Context Webservice ------------------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/users").
					accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			LOGGER.info("------------------ Getting HTTP Response ------------------");
			String content = mvcResult.getResponse().getContentAsString();
			LOGGER.info("------------------ Deserializing JSON Response ------------------");
			User[] userList = this.mapFromJson(content, User[].class);
			assertTrue(userList.length > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Test de l'appel de la méthode du service
	
	@Test
	public void testfindAll() {
		LOGGER.info("------------------ Testing testfindAll Method ------------------");
		userController.findAll();
		LOGGER.info("------------------ Verifying findAll Method ------------------");
		verify(userServiceToMock).findAll();
	}

	
	/**
	 * 
	 * TEST ADD()
	 * 
	 */
	
	
	//Test du statut
	
	@Test
	public void testAddStatus() {
		LOGGER.info("------------------ Testing testAddStatus Method ------------------");
		LOGGER.info("------------------ Constructing User ------------------");
		User user = new User();
		try {
			LOGGER.info("------------------ Serializing User Object ------------------");
			String inputJson = this.mapToJson(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult;

			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/add")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test du retour
	
	@Test
	public void createEntity() {
		LOGGER.info("------------------ Testing createEntity Method ------------------");
		LOGGER.info("------------------ Constructing Utilisateur ------------------");
		User user = userService.add(User.builder().firstName("José").build());
		int userId = user.getId_user();

		MvcResult mvcResult;
		try {
			LOGGER.info("------------------ Serializing Utilisateur Object ------------------");
			String inputJson = this.mapToJson(user);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/add")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("------------------ Searching for Utilisateur ------------------");
			User userFound = userService.getById(userId);
			LOGGER.info("------------------ Verifying Utilisateur ------------------");
			assertEquals(userFound.getFirstName(), user.getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//Test de l'appel de la méthode du service

	@Test
	public void testAjoutUtilisateur() {
		LOGGER.info("------------------ Testing testAjoutUtilisateur Method ------------------");
		LOGGER.info("------------------ Constructing Utilisateur ------------------");
		User user = new User();
		LOGGER.info("------------------ Saving Utilisateur ------------------");
		userController.add(user);
		LOGGER.info("------------------ Verifying addUser Method ------------------");
		verify(userServiceToMock).add(user);
	}

	
	/**
	 * 
	 * TEST UPDATE()
	 * 
	 */
	
	//Test du statut

	@Test
	public void updateUser() {

		try {
			LOGGER.info("------------------ Testing updateUser Method ------------------");
			LOGGER.info("------------------ Constructing User ------------------");
			User oldUser = userService.add(User.builder().firstName("José").build());
			LOGGER.info("------------------ Saving User ------------------");
			userService.add(oldUser);
			LOGGER.info("------------------ Modifying User ------------------");
			oldUser.setFirstName("Ricco");
			User newUser = new User(2, "Lemonade");

			LOGGER.info("------------------ Serializing User Object ------------------");
			String inputJson = this.mapToJson(newUser);
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/2")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
			LOGGER.info("------------------ Searching for User ------------------");
			User userFound = userService.getUserById(new Long(2));
			LOGGER.info("------------------ Verifying User ------------------");
			assertEquals(userFound.getUserName(), newUser.getUserName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test du retour
	
	//Test de l'appel de la méthode du service

	
	/**
	 * 
	 * TEST DELETE()
	 * 
	 */

	//Test du statut
	@Test
	public void deleteEntityStatus() {
		LOGGER.info("------------------ Testing deleteEntity Method ------------------");

		try {
			LOGGER.info("------------------ Constructing Utilisateur ------------------");
			LOGGER.info("------------------ Saving Utilisateur ------------------");
			userService.addUser(new User(2, "Lemon"));
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/2")).andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
			LOGGER.info("------------------ Searching for Utilisateur ------------------");
			User userFound = userService.getUserById(new Long(2));
			LOGGER.info("------------------ Verifying Utilisateur ------------------");
			assertEquals(userFound, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test du retour
	@Test
	public void deleteEntity() {
		LOGGER.info("------------------ Testing deleteEntity Method ------------------");

		try {
			LOGGER.info("------------------ Constructing Utilisateur ------------------");
			LOGGER.info("------------------ Saving Utilisateur ------------------");
			userService.addUser(new User(2, "Lemon"));
			LOGGER.info("------------------ Mocking Context Webservice and invoking the webservice ------------------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/2")).andReturn();
			LOGGER.info("------------------ Getting HTTP Status ------------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("------------------ Verifying HTTP Status ------------------");
			assertEquals(200, status);
			LOGGER.info("------------------ Searching for Utilisateur ------------------");
			User userFound = userService.getUserById(new Long(2));
			LOGGER.info("------------------ Verifying Utilisateur ------------------");
			assertEquals(userFound, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Test de l'appel de la méthode du service


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
