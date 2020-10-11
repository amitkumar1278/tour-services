/**
 * 
 */
package com.tour.sb.ms.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tour.sb.ms.domain.Tour;

/**
 * @author amit
 *
 * Tour Repository Interface
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {
	List<Tour> findByTourPackageCode( @Param("code") String code);
	
}
