package com.example.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param tourRepository Tour Repository
     */
    @Autowired
    public TourRatingService(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

 




}
