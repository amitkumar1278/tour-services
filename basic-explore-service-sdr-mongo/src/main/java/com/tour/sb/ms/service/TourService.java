/**
 * 
 */
package com.tour.sb.ms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.sb.ms.domain.Tour;
import com.tour.sb.ms.domain.TourPackage;
import com.tour.sb.ms.repo.TourPackageRepository;
import com.tour.sb.ms.repo.TourRepository;

/**
 * @author amit
 *
 * Tour Service
 */

@Service
public class TourService {

	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;

	/**
	 * @param tourRepository
	 * @param tourPackageRepository
	 */
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}


    /**
     * Create a new Tour Object and persist it to the Database
     *
     * @param title Title of the tour
     * @param tourPackageName tour Package of the tour
     * @param details Extra details about the tour
     * @return Tour
     */
	public Tour createTour(String title, String tourPackageName, Map<String, String> details) {

		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(()->
		new RuntimeException("Tour package does not exist: " + tourPackageName));

		System.out.println("TourService : createTour : fetched tourPackage : "+ tourPackage.toString());

		return tourRepository.save(new Tour(title, tourPackage, details));

	}


	/**
	 * Calculate the number of Tours in the Database.
	 * 
	 * @return
	 */
	public long total() {
		return tourRepository.count();
	}
}
