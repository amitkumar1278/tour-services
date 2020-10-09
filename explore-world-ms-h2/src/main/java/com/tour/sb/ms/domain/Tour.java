/**
 * 
 */
package com.tour.sb.ms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author amit
 *
 */

@Entity
public class Tour implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String title;
	
	@Column(length = 2000)
	private String description;
	
	@Column(length = 2000)
	private String blurb;
	
	@Column
	private Integer price;
	
	@Column
	private String duration;
	
	@Column(length = 2000)
	private String bullets;
	
	@Column
	private String keywords;
	
	@ManyToOne
	private TourPackage tourPackage;
	
	@Column
	@Enumerated
	private Difficulty difficulty;
	
	@Column
	@Enumerated
	private Region region;

	protected Tour() {
		
	}

	/**
	 * @param title
	 * @param description
	 * @param blurb
	 * @param price2
	 * @param duration
	 * @param bullets
	 * @param keywords
	 * @param tourPackage
	 * @param difficulty
	 * @param region
	 */
	public Tour(String title, String description, String blurb, Integer price2, String duration, String bullets,
			String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
		super();
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price2;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
		this.tourPackage = tourPackage;
		this.difficulty = difficulty;
		this.region = region;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the blurb
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * @param blurb the blurb to set
	 */
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the bullets
	 */
	public String getBullets() {
		return bullets;
	}

	/**
	 * @param bullets the bullets to set
	 */
	public void setBullets(String bullets) {
		this.bullets = bullets;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the tourPackage
	 */
	public TourPackage getTourPackage() {
		return tourPackage;
	}

	/**
	 * @param tourPackage the tourPackage to set
	 */
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	/**
	 * @return the difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", title=" + title + ", description=" + description + ", blurb=" + blurb + ", price="
				+ price + ", duration=" + duration + ", bullets=" + bullets + ", keywords=" + keywords
				+ ", tourPackage=" + tourPackage + ", difficulty=" + difficulty + ", region=" + region + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blurb == null) ? 0 : blurb.hashCode());
		result = prime * result + ((bullets == null) ? 0 : bullets.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tourPackage == null) ? 0 : tourPackage.hashCode());
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
		if (blurb == null) {
			if (other.blurb != null)
				return false;
		} else if (!blurb.equals(other.blurb))
			return false;
		if (bullets == null) {
			if (other.bullets != null)
				return false;
		} else if (!bullets.equals(other.bullets))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (region != other.region)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tourPackage == null) {
			if (other.tourPackage != null)
				return false;
		} else if (!tourPackage.equals(other.tourPackage))
			return false;
		return true;
	}
	
	
}
