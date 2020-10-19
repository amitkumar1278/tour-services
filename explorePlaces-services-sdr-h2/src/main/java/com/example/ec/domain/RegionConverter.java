/**
 * 
 */
package com.example.ec.domain;

import javax.persistence.AttributeConverter;

import org.hibernate.CustomEntityDirtinessStrategy.AttributeChecker;
import org.hibernate.CustomEntityDirtinessStrategy.AttributeInformation;

/**
 * @author amit
 *
 */
public class RegionConverter implements AttributeConverter<Region, String> {

	@Override
	public String convertToDatabaseColumn(Region attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return null;
	}


}
