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
	
	@Autowired
	private IUserRepository userRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);
	
	@Test
	public void givenEntityRepository_saveMethod() {
		LOGGER.info("____________Test UserRepository .save Method________________");
		//given
		User dhia = User.builder().name("Dhia").build();
		LOGGER.info("____________User saved________________");
		userRepo.save(dhia);
		//when
		LOGGER.info("____________Call User________________");
		User calledDhia = userRepo.getOne(1);
		//then
		LOGGER.info("____________Test equal________________");
		assertEquals(dhia, calledDhia);
		
		/**
	    Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Employee found = employeeRepository.findByName(alex.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
	     */
	}

}
