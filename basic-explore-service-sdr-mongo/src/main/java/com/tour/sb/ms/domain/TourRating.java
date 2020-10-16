/**
 * 
 */
package com.tour.sb.ms.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *  Rating of a Tour by a Customer
 *  
 * @author amit
 *
 */
@Document
public class TourRating {

	
	@Id
	private String Id;
	
	private String tourId;
	
	@NotNull
	private Integer customerId;

	@Min(0)
	@Max(5)
	private Integer score;
	
	@Size(max = 255)
	private String comment;
	
	protected TourRating() {
		
	}




	 /**
     * Construct a new Tour Rating.
     *
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @param score Integer score (1-5)
     * @param comment Optional comment from the customer
     */
	public TourRating(String tourId, @NotNull Integer customerId, @Min(0) @Max(5) Integer score,
			@Size(max = 255) String comment) {
		super();
		this.tourId = tourId;
		this.customerId = customerId;
		this.score = score;
		this.comment = comment;
	}




	

	/**
	 * @return the tourId
	 */
	public String getTourId() {
		return tourId;
	}




	/**
	 * @param tourId the tourId to set
	 */
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}




	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}




	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}




	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}




	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((tourId == null) ? 0 : tourId.hashCode());
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
		TourRating other = (TourRating) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (tourId == null) {
			if (other.tourId != null)
				return false;
		} else if (!tourId.equals(other.tourId))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "TourRating [Id=" + Id + ", tourId=" + tourId + ", customerId=" + customerId + ", score=" + score
				+ ", comment=" + comment + "]";
	}




	
	
}
