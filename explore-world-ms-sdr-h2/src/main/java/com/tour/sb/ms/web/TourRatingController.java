/**
 * 
 */
package com.tour.sb.ms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.sb.ms.repo.TourRatingRepository;
import com.tour.sb.ms.repo.TourRepository;

/**
 * Tour Rating Controller
 * 
 * @author amit
 *
 */

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

	TourRatingRepository tourRatingRepository;
	TourRepository tourRepository;

	@Autowired
	public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepository = tourRepository;
	}

	protected TourRatingController() {

	}

}
