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
import com.inti.formation.entity.User;
import com.inti.formation.repository.IUserRepository;
import com.inti.formation.repository.UserRepositoryTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookMySeatApplication.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private IUserRepository userRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);
	private User user = User.builder().id_user(1).name("Piano").build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Testing .add method
	 */
	@Test
	public void call_userRepo_add_method() {
		 LOGGER.info("______________ Test of .add Method call _______________");
		 userService.add(user);
		 verify(userRepo).save(user);
	}
	
	@Test
	public void return_user_for_add_method() {
		LOGGER.info("______________ Test of .add Method return _______________");
		Mockito.when(userRepo.save(user)).thenReturn(User.builder().firstName("Patate").build());
		assertEquals(User.builder().firstName("Patate").build(), userService.add(user));
	}

	/**
	 * Testing .update method
	 */
	@Test
	public void call_userRepo_update_method() {
		 LOGGER.info("______________ Test of .update Method call _______________");
		 userService.update(user);
		 verify(userRepo).save(user);
	}
	
	@Test
	public void return_user_for_update_method() {
		LOGGER.info("______________ Test of .update Method return _______________");
		Mockito.when(userRepo.save(user)).thenReturn(User.builder().firstName("Patate").build());
		assertEquals(User.builder().firstName("Patate").build(), userService.update(user));
	}
	
	/**
	 * Testing .getById method
	 */
	@Test
	public void call_userRepo_getById_method() {
		 LOGGER.info("______________ Test of .getById Method call _______________");
		 userService.getById(1);
		 verify(userRepo).getOne(1);
	}
	
	@Test
	public void return_user_for_getById_method() {
		LOGGER.info("______________ Test of .getById Method return _______________");
		Mockito.when(userRepo.getOne(1)).thenReturn(User.builder().firstName("Patate").build());
		assertEquals(User.builder().firstName("Patate").build(), userService.getById(1));
	}

	/**
	 * Testing .findAll method
	 */
	@Test
	public void call_userRepo_findAll_method() {
		 LOGGER.info("______________ Test of .findAll Method call _______________");
		 userService.findAll();
		 verify(userRepo).findAll();
	}
	
	@Test
	public void return_user_for_findAll_method() {
		LOGGER.info("______________ Test of .findAll Method return _______________");
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(User.builder().id_user(2).name("Ponyo").build());
		Mockito.when(userRepo.findAll()).thenReturn(users);
		assertEquals(users, userService.findAll());
	}
	
	/**
	 * Testing .delete method
	 */
	@Test
	public void call_userRepo_delete_method() {
		 LOGGER.info("______________ Test of .delete Method call _______________");
		 userService.delete(1);
		 verify(userRepo).deleteById(1);
	}
}
