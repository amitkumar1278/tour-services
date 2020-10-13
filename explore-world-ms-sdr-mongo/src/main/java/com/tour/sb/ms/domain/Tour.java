/**
 * 
 */
package com.tour.sb.ms.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * This MongoDb Document Collection schema is different than the JPA Entity.
 * Only id, title, and tourPackage are identified and indexed.
 * The rest of the fields are grouped into a Map.
 *
 * @author amit
 */
@Document
public class Tour {



	@Id
	private Integer id;

    @Indexed
	private String title;

	@Indexed
	private String tourPackageCode;

	private String tourPackageName;

	private Map<String, String> details;
	
	
	protected Tour() {

	}

	
	/**
	 * @param title
	 * @param tourPackageCode
	 * @param tourPackageName
	 * @param details
	 */
	public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
		super();
		this.title = title;
		this.tourPackageCode = tourPackage.getCode();
		this.tourPackageName = tourPackage.getName();
		this.details = details;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the tourPackageCode
	 */
	public String getTourPackageCode() {
		return tourPackageCode;
	}


	/**
	 * @return the tourPackageName
	 */
	public String getTourPackageName() {
		return tourPackageName;
	}


	/**
	 * @return the details
	 */
	public Map<String, String> getDetails() {
		return details;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tour [id=" + id + ", details=" + details + "]";
	}


	

}
