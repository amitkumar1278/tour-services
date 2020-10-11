/**
 * 
 */
package com.tour.sb.ms.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tour.sb.ms.domain.TourPackage;

/**
 * @author amit
 *
 *  Tour Package Repository Interface
 */
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {


	/**
	 * @param name
	 * @return
	 */
	Optional<TourPackage> findByName(String name);
	
}
