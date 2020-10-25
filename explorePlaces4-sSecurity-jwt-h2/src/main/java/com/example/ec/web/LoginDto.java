/**
 * 
 */
package com.example.ec.web;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

/**
 * @author amit
 *
 */

public class LoginDto {

	@NotNull
	private String username;

	@NotNull
	private String password;

	private String firstName;

	private String lastName;

	/**
	 * Default constructor
	 */
	protected LoginDto() {
	}

	/**
	 * Partial constructor
	 * @param username
	 * @param password
	 */
	public LoginDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Full constructor
	 * @param username
	 * @param password
	 */
	public LoginDto(String username, String password, String firstName, String lastName) {
		this(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

}
