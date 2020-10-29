package com.example.ec.web;

import org.junit.Test;

import com.example.ec.dto.LoginDto;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author amit
 *
 */
public class LoginDtoTest {

    @Test
    public void testAll() {
        LoginDto dto = new LoginDto("user","pwd");
        assertThat(dto.getUsername(), is("user"));
        assertThat(dto.getPassword(), is("pwd"));
    }
}