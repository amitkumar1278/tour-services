/**
 * 
 */
package com.tour.sb.ms.repo;

import org.springframework.data.repository.CrudRepository;

import com.tour.sb.ms.domain.Tour;

/**
 * @author amit
 *
 * Tour Repository Interface
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {

}
