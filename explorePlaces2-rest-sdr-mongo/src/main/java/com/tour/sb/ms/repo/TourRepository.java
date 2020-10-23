/**
 * 
 */
package com.tour.sb.ms.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.tour.sb.ms.domain.Tour;

/**
 * @author amit
 *
 * Tour Repository Interface
 */
public interface TourRepository extends PagingAndSortingRepository<Tour, String> {

    /**
     * Find Tours associated with the Tour Package.
     *
     * @param code tour package code
     * @return List of found tours.
     */
	Page<Tour> findByTourPackageCode( @Param("code") String code, Pageable pageable);

	/**
     * Only return the main fields of a Tour, not the details
     *
     * @param code tour package code
     * @return tours without details
     */
	@Query(value = "{'tourPackageCode': ?0}", 
			fields = "{'id':1, 'title':1, 'tourPackageCode':1, 'tourPackageName':1}")
	Page<Tour> findSummaryByTourPackageCode(@Param("code") String code, Pageable pageable);
	
	@Override
	@RestResource(exported = false)
	<S extends Tour> S save(S entity);

	@Override
	@RestResource(exported = false)
	<S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

	@Override
	@RestResource(exported = false)
	void deleteById(String id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Tour tour);

	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Tour> tours);

	@Override
	@RestResource(exported = false)
	void deleteAll();

}
