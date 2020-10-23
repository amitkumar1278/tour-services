/**
 * 
 */
package com.example.ec.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.service.UserService;

/**
 * @author amit
 *
 */

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public Authentication login(@RequestBody @Valid LoginDto loginDto) {
		return userService.signin(loginDto.getUsername(), loginDto.getFirstName());
	}
}
