/**
 * 
 */
package com.example.ec.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ec.domain.Tour;
import com.example.ec.domain.TourRating;
import com.example.ec.service.TourRatingService;

/**
 * @author amit
 * 
 *         Invoke the Controller methods via HTTP. Do not invoke the
 *         tourRatingService methods, use Mock instead
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RatingControllerTest {

	private static final String RATINGS_URL = "/ratings";

	/**
	 * These Tour and rating id's do not already exist in the db
	 */
	private static final int TOUR_ID = 999;
	private static final int RATING_ID = 555;
	private static final int CUSTOMER_ID = 1000;
	private static final int SCORE = 3;
	private static final String COMMENT = "COMMENT";

	@MockBean
	private TourRatingService tourRatingServiceMock;

	@Mock
	private TourRating tourRatingMock;

	@Mock
	private Tour tourMock;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setupReturnValuesOfMockMethods() {
		when(tourRatingMock.getTour()).thenReturn(tourMock);
		when(tourRatingMock.getId()).thenReturn(TOUR_ID);
		when(tourRatingMock.getComment()).thenReturn(COMMENT);
		when(tourRatingMock.getScore()).thenReturn(SCORE);
		when(tourRatingMock.getCustomerId()).thenReturn(CUSTOMER_ID);
	}

	/**
	 * HTTP GET /ratings
	 */
	@Test
	public void getRatings() {

		when(tourRatingServiceMock.lookupAll())
		.thenReturn(Arrays.asList(tourRatingMock, tourRatingMock, tourRatingMock));
		ResponseEntity<List> response = restTemplate.getForEntity(RATINGS_URL, List.class);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody().size(), is(3));
	}

	/**
	 *  HTTP GET /ratings/{id}
	 */
	@Test
	public void getOne() {

		when(tourRatingServiceMock.lookupRatingById(RATING_ID)).thenReturn(Optional.of(tourRatingMock));
		ResponseEntity<RatingDto> response = restTemplate.getForEntity(RATINGS_URL + "/" + RATING_ID, RatingDto.class);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody().getCustomerId(), is(CUSTOMER_ID));
		assertThat(response.getBody().getComment(), is(COMMENT));
		assertThat(response.getBody().getScore(), is(SCORE));
	}
	
	
	@Test//(expected = NoSuchElementException.class)
	public void getOneNotFound() {
		
		when(tourRatingServiceMock.lookupRatingById(RATING_ID)).thenReturn(Optional.empty());
		ResponseEntity<String> response = restTemplate.getForEntity(RATINGS_URL + "/" +RATING_ID, String.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
		assertThat(response.getBody(), containsString("Rating "+ RATING_ID + " not found"));
	}
}
