/**
 * 
 */
package com.example.ec.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * @author amit
 *
 */
public class LoginDtoTest {
	
	@Test
	public void testAll() {
		LoginDto dto = new LoginDto("user", "pwd");
		assertThat(dto.getUsername(), is("user"));
		assertThat(dto.getPassword(), is("pwd"));
	}

}
