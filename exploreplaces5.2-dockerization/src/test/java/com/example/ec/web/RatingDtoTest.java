package com.example.ec.web;

import org.junit.Test;

import com.example.ec.dto.RatingDto;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author amit
 *
 */
public class RatingDtoTest {
    @Test
    public void testConstructor() throws Exception {
        RatingDto dto = new RatingDto(1,"comment", 2);
        assertThat(dto.getScore(), is(1));
        assertThat(dto.getComment(), is("comment"));
        assertThat(dto.getCustomerId(), is(2));
    }

    @Test
    public void testSetters() {
        RatingDto dto = new RatingDto();
        dto.setComment("comment");
        dto.setCustomerId(2);
        dto.setScore(1);
        assertThat(dto.getScore(), is(1));
        assertThat(dto.getComment(), is("comment"));
        assertThat(dto.getCustomerId(), is(2));
    }

}