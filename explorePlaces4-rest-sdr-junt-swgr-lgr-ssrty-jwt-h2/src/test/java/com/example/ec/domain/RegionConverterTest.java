/**
 * 
 */
package com.example.ec.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * @author amit
 *
 */
public class RegionConverterTest {

	private RegionConverter converter = new RegionConverter();

	@Test
	public void convertToDatabaseColumn() throws Exception {
		assertThat(converter.convertToDatabaseColumn(Region.Central_Coast), is(Region.Central_Coast.getLabel()));
	}

	@Test
	public void convertToEntityAttribute() throws Exception {
		assertThat(converter.convertToEntityAttribute(Region.Central_Coast.getLabel()), is(Region.Central_Coast));
	}
}
