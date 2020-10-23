/**
 * 
 */
package com.tour.sb.ms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author amit
 *
 */

@Embeddable
public class TourRatingPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Tour tour;
	
	@Column(insertable = false, updatable = false, nullable = false)
	private Integer customerId;
	
	public TourRatingPK() {
		
	}

	/**
	 * Fully initialize a Tour Rating Pk
	 * 
	 * @param tour
	 * @param customerId
	 */
	public TourRatingPK(Tour tour, Integer customerId) {
		super();
		this.tour = tour;
		this.customerId = customerId;
	}

	/**
	 * @return the tour
	 */
	public Tour getTour() {
		return tour;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((tour == null) ? 0 : tour.hashCode());
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
		TourRatingPK other = (TourRatingPK) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (tour == null) {
			if (other.tour != null)
				return false;
		} else if (!tour.equals(other.tour))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TourRatingPK [tour=" + tour + ", customerId=" + customerId + "]";
	}
	
	
	
}
