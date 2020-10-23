/**
 * 
 */
package com.example.ec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author amit
 *
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);

		/**
		 * Entry points
		 */
		http.authorizeRequests()
		.antMatchers("/packages/**").permitAll()
		.antMatchers("/tours/**").permitAll()
		.antMatchers("/ratings/**").permitAll()
		.antMatchers("/user/signin").permitAll()
		.antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
		// Disallow everything else..
		.anyRequest().authenticated();

		/**
		 * Disable CSRF (cross site request forgery) 
		 */
		http.csrf().disable();

		/**
		 * No session will be created or used by spring security 
		 */
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder(12);
	}

}