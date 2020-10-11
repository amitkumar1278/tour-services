/**
 * 
 */
package com.tour.sb.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.sb.ms.domain.TourPackage;
import com.tour.sb.ms.repo.TourPackageRepository;

/**
 * @author amit
 * 
 *         Tour Package Service
 */

@Service
public class TourPackageService {

	/**
	 * 
	 */
	private TourPackageRepository tourPackageRepository;

	/**
	 * @param tourPackageRepository
	 */
	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}

	/**
	 * Create a Tour Package
	 * 
	 * @param code
	 * @param name
	 * @return new or existing tour package
	 */
	public TourPackage createTourPackage(String code, String name) {
		return tourPackageRepository.findById(code)
				.orElse(tourPackageRepository.save(new TourPackage(code, name)));
	}
	
	
	/**
	 *  Lookup All Tour packages
	 *  
	 * @return
	 */
	public Iterable<TourPackage> lookup(){
		return tourPackageRepository.findAll();
	}
	
	/**
	 * @return
	 */
	public long total() {
		return tourPackageRepository.count();
	}
}
