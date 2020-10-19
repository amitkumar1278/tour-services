/**
 * 
 */
package com.example.ec.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author amit
 *
 */

@Converter(autoApply = true)
public class RegionConverter implements AttributeConverter<Region, String> {

	@Override
	public String convertToDatabaseColumn(Region region) {
		// TODO Auto-generated method stub
		return region.getLabel();
	}

	@Override
	public Region convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return Region.findByLabel(dbData);
	}

}
