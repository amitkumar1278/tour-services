/**
 * 
 */
package com.tour.sb.ms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author amit
 *
 */
@Entity
public class TourRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TourRatingPK pk;
	
	@Column(nullable = false)
	private Integer score;
	
	@Column
	private String comment;

	
	protected TourRating() {
		
	}


	/**
     * Create a fully initialized TourRating.
     *
     * @param pk         primiary key of a tour and customer id.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
	 */
	public TourRating(TourRatingPK pk, Integer score, String comment) {
		super();
		this.pk = pk;
		this.score = score;
		this.comment = comment;
	}


	/**
	 * @return the pk
	 */
	public TourRatingPK getPk() {
		return pk;
	}


	/**
	 * @param pk the pk to set
	 */
	public void setPk(TourRatingPK pk) {
		this.pk = pk;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TourRating [pk=" + pk + ", score=" + score + ", comment=" + comment + "]";
	}
	
	
}
