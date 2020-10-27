package com.example.ec.web;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author amit
 *
 */
public class LoginDtoTest {

    @SuppressWarnings("deprecation")
	@Test
    public void testAll() {
        LoginDto dto = new LoginDto("user","pwd");
        assertThat(dto.getUsername(), is("user"));
        assertThat(dto.getPassword(), is("pwd"));
    }
}