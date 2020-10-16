/**
 * 
 */
package com.tour.sb.ms.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tour.sb.ms.domain.TourRating;



/**
 * Data Transfer Object for Rating a Tour.
 * 
 * @author amit
 *
 */
public class RatingDto {
	
	@Min(0)
	@Max(5)
	private Integer score;
	
	@Size(max = 255)
	private String comment;
	
	@NotNull
	private Integer customerId;
	
	protected RatingDto() {
		
	}
	
    /**
     * Construct a RatingDto from a fully instantiated TourRating.
     *
     * @param tourRating Tour Rating Object
     */
	public RatingDto(TourRating tourRating) {
		this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
	}


    /**
     * Constructor to fully initialize the RatingDto
     *
     * @param score score 1-5
     * @param comment comment
     * @param customerId customer identifier
     */
	public RatingDto(Integer score, String comment, Integer customerId) {
		// TODO Auto-generated constructor stub
		this.score = score;
		this.comment = comment;
		this.customerId = customerId;
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

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
