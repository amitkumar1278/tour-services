/**
 * 
 */
package com.example.ec.web;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ec.domain.Tour;
import com.example.ec.domain.TourRating;
import com.example.ec.service.TourRatingService;

/**
 * Invoke the Controller methods via HTTP.
 * Do not invoke the tourRatingService methods, use Mock instead
 * 
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TourRatingControllerTest {

	//These Tour and rating id's do not already exist in the db
	private static final int TOUR_ID = 999;
	private static final int CUSTOMER_ID = 1000;
	private static final int SCORE = 3;
	private static final String COMMENT = "comment";
	private static final String TOUR_RATINGS_URL = "/tours/" + TOUR_ID + "/ratings";

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private TourRatingService serviceMock;

	@Mock
	private TourRating tourRatingMock;

	@Mock
	private Tour tourMock;

	private RatingDto ratingDto = new RatingDto(SCORE, COMMENT, CUSTOMER_ID);

	
	@Before
	public void setupReturnValuesOfMockMethods() {
		when(tourRatingMock.getComment()).thenReturn(COMMENT);
		when(tourRatingMock.getScore()).thenReturn(SCORE);
		when(tourRatingMock.getCustomerId()).thenReturn(CUSTOMER_ID);
		when(tourRatingMock.getTour()).thenReturn(tourMock);
		when(tourRatingMock.getId()).thenReturn(TOUR_ID);
	}


	/**
	 * HTTP POST /tours/{tourId}/ratings
	 */
	@Test
	public void createTourRating() throws Exception {
		restTemplate.postForEntity(TOUR_RATINGS_URL, ratingDto, Void.class);
		verify(this.serviceMock).createNew(TOUR_ID, CUSTOMER_ID, SCORE, COMMENT);
	}

}
