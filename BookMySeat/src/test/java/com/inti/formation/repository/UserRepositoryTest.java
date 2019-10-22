package com.inti.formation.repository;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	
//	@Autowired
//	private IUserRepository userRepo;
//	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);
//	
//	@Test
//	public void givenEntityRepository_whenSaving() {
//		LOGGER.info("------------------ Testing givenEntityRepository_whenSaving Method --------------");
//		System.out.println(userRepo);
//		User addedUser = userRepo.save(User.builder().name("Zidane").build());
//		LOGGER.info("----------- User seved -------");
//		LOGGER.info("----------- Searching for User -------");
//		User foundUser = userRepo.getOne(addedUser.getId_user());
//		LOGGER.info("----------- User found -------");
//		LOGGER.info("----------- Verifying User -------");
//		assertEquals(addedUser.getName(), foundUser.getName());
//		LOGGER.info("----------- User verified -------");
//	}
//	
	@Autowired
	private IUserRepository userRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

	@Test
	public void givenEntityRepository_saveMethod() {
		LOGGER.info("____________Test UserRepository .save Method________________");
		// given
		User dhia = User.builder().name("Dhia").build();
		LOGGER.info("____________User saved________________");
		userRepo.save(dhia);
		// when
		LOGGER.info("____________Call User________________");
		User calledDhia = userRepo.getOne(1);
		// then
		LOGGER.info("____________Test equal________________");
		assertEquals(dhia.getName(), calledDhia.getName());

		/**
		 * Employee alex = new Employee("alex"); entityManager.persist(alex);
		 * entityManager.flush();
		 * 
		 * // when Employee found = employeeRepository.findByName(alex.getName());
		 * 
		 * // then assertThat(found.getName()) .isEqualTo(alex.getName());
		 */
	}

}
