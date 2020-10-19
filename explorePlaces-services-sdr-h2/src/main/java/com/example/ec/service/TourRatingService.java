package com.example.ec.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.domain.Tour;
import com.example.ec.domain.TourRating;
import com.example.ec.repo.TourRatingRepository;
import com.example.ec.repo.TourRepository;

/**
 * Tour Rating Service
 *
 * @author amit
 */
@Service
public class TourRatingService {

	private TourRatingRepository tourRatingRepository;
	private TourRepository tourRepository;

	/**
	 * Construct TourRatingService
	 *
	 * @param tourRatingRepository Tour Rating Repository
	 * @param tourRepository       Tour Repository
	 */
	@Autowired
	public TourRatingService(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepository = tourRepository;
	}

    /**
     * Create a new Tour Rating in the database
     *
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @param score score of the tour rating
     * @param comment additional comment
     * @throws NoSuchElementException if no Tour found.
     */
	public void createNew(int tourId, Integer customerId, Integer score, String comment) throws NoSuchElementException {
		tourRatingRepository.save(new TourRating(verifyTour(tourId), customerId, score, comment));
	}

	
    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
	private Tour verifyTour(int tourId) throws NoSuchElementException {

		return tourRepository.findById(tourId)
				.orElseThrow(() -> new NoSuchElementException("Tour does not exist " + tourId));
	}

}
