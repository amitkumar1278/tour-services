/**
 * 
 */
package com.tour.sb.ms.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.tour.sb.ms.domain.TourPackage;

/**
 * @author amit
 *
 *  Tour Package Repository Interface
 */

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    /**
     * Find Tour Package by name.
     *
     * @param name name of the package
     * @return Optional of TourPackage
     */
	Optional<TourPackage> findByName(String name);

	/**
	 * using RestResource(exported = false), you can prevent SDR from exporting a given method.
	 */
	
	@Override
	@RestResource(exported = false)
	<S extends TourPackage> S save(S tourPackage);

	@Override
	@RestResource(exported = false)
	<S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities);

	@Override
	@RestResource(exported = false)
	void deleteById(String id);

	@Override
	@RestResource(exported = false)
	void delete(TourPackage tourPackage);

	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends TourPackage> entities);

	@Override
	@RestResource(exported = false)
	void deleteAll();

	

	
}
