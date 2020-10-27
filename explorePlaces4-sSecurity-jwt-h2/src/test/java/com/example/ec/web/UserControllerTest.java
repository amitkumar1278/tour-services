/**
 * 
 */
package com.example.ec.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ec.domain.Role;
import com.example.ec.domain.User;
import com.example.ec.dto.LoginDto;
import com.example.ec.service.UserService;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	private LoginDto signupDto = new LoginDto("larry", "1234", "larry", "miller");
	private User user = new User(signupDto.getUsername(), signupDto.getPassword(), 
			new Role(), signupDto.getFirstName(), signupDto.getLastName());


	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private JwtRequestHelper jwtRequestHelper;
	
	@MockBean
	private UserService service;

	@Test
	public void signin() {
		restTemplate.postForEntity("/users/signin", new LoginDto("admin", "myPass"),  Void.class);
		verify(this.service).signin("admin", "myPass");
	}


	@SuppressWarnings("rawtypes")
	@Test
	public void signup() {

		when(service.signup(signupDto.getUsername(), signupDto.getPassword(), signupDto.getFirstName(), signupDto.getLastName()))
		.thenReturn(Optional.of(user));

		@SuppressWarnings("unchecked")
		ResponseEntity<User> response = restTemplate.exchange("/users/signup", 
				HttpMethod.POST, 
				new HttpEntity(signupDto, jwtRequestHelper.withRole("ROLE_ADMIN")),
				User.class);

		assertThat(response.getStatusCode().value(), is(201));
		assertThat(response.getBody().getUsername(), is(user.getUsername()));
		assertThat(response.getBody().getFirstName(), is(user.getFirstName()));
		assertThat(response.getBody().getLastName(), is(user.getLastName()));
		assertThat(response.getBody().getRoles().size(), is(user.getRoles().size()));
	}


	@Test
	public void signupUnauthoried() {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<User> response = restTemplate.exchange("/users/signup", 
				HttpMethod.POST,
				new HttpEntity(signupDto, jwtRequestHelper.withRole("ROLE_CSR")),
				User.class);

		assertThat(response.getStatusCode().value(), is(403));
	}


	@Test
	public void getAllUsers() {
		when(service.getAll()).thenReturn(Arrays.asList(user));

		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<List<User>> response = restTemplate.exchange("/users", 
				HttpMethod.GET,
				new HttpEntity(jwtRequestHelper.withRole("ROLE_ADMIN")),
				new ParameterizedTypeReference<List<User>>() {	});

		assertThat(response.getStatusCode().value(), is(200));
		assertThat(response.getBody().get(0).getUsername(), is(user.getUsername()));
	}

}
