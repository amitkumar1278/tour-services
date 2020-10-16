/**
 * 
 */
package com.tour.sb.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.sb.ms.domain.Difficulty;
import com.tour.sb.ms.domain.Region;
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
	 * Create a new Tour Object and persist it to the Database.
	 * 
	 * @param title
	 * @param description
	 * @param blurb
	 * @param price
	 * @param duration
	 * @param bullets
	 * @param keywords
	 * @param tourPackageName
	 * @param difficulty
	 * @param region
	 * @return
	 */
	public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
			String keywords, String tourPackageName, Difficulty difficulty, Region region) {

		//		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(()->
		new RuntimeException("Tour package does not exist: " + tourPackageName));

		System.out.println("TourService : createTour : passed tourPackageName : "+ tourPackageName + ", fetched tourPackage : "+ tourPackage.toString());

		if(null == tourPackage || !tourPackage.getName().equalsIgnoreCase(tourPackageName)) {
			throw new RuntimeException("Tour pacakge does not exist: "+ tourPackageName);
		}

		return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));

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
