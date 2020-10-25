/**
 * 
 */
package com.example.ec.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.domain.User;
import com.example.ec.service.UserService;

/**
 * @author amit
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public Authentication login(@RequestBody @Valid LoginDto loginDto) {
		return userService.signin(loginDto.getUsername(), loginDto.getPassword());
	}


	@PostMapping("/signup")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User signup(@RequestBody @Valid LoginDto loginDto ) {

		return userService.signup(loginDto.getUsername(), 
				loginDto.getPassword(), loginDto.getFirstName(), loginDto.getLastName())
				.orElseThrow(() -> new RuntimeException("User already exists"));
	}


	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllUsers(){
		return userService.getAll();
	}


	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *
	 * @param ex exception
	 * @return Error message String.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RuntimeException.class)
	public String return400(RuntimeException ex) {

		LOGGER.error("Unable to complete transaction", ex);
		return ex.getMessage();
	}

}
