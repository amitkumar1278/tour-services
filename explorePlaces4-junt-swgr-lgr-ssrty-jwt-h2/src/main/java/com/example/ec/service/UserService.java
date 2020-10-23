/**
 * 
 */
package com.example.ec.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ec.repo.RoleRepository;
import com.example.ec.repo.UserRepository;

/**
 * @author amit
 *
 */

@Service
public class UserService {

	private UserRepository userRepository;

	private AuthenticationManager authenticationManager;

	private RoleRepository roleRepository;

	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, AuthenticationManager authenticationManager,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public Authentication signin(String username, String password) {
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
