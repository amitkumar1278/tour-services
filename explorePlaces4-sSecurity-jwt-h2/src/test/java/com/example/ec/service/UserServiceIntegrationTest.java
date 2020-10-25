/**
 * 
 */
package com.example.ec.service;

import static org.hamcrest.CoreMatchers.not;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.not;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

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
@Transactional
public class UserServiceIntegrationTest {

	@Autowired
	private UserService service;
	
	@SuppressWarnings("deprecation")
	@Test
	public void signup() {
		Optional<User> user = service.signup("dummyUsername", "dummypassword", "john", "doe");
		
		assertThat(user.get().getPassword(), not("dummypassword"));
		System.out.println("Encoded Password = "+user.get().getPassword());
	}
}
