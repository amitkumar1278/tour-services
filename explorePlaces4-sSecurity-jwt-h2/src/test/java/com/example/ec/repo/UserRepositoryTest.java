/**
 * 
 */
package com.example.ec.repo;

import static org.junit.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ec.domain.User;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void testFindByUserName() {
		
		Optional<User> user = repository.findByUsername("admin");
		assertTrue(user.isPresent());
		
		user = repository.findByUsername("nobody");
		assertFalse(user.isPresent());
		
	}
}
