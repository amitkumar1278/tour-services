/**
 * 
 */
package com.tour.sb.ms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tour.sb.ms.domain.TourRating;
import com.tour.sb.ms.domain.TourRatingPK;

/**
 *  Tour Rating Repository Interface
 *  
 * @author amit
 *
 */
@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPK> {

	/**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
	 */
	List<TourRating> findByPkTourId(Integer tourId);
	
	/**
     * Lookup a TourRating by the TourId and Customer Id
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @return Optional of found TourRatings.
	 */
	Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
