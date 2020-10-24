
Tour-service is implementation of microservice using Spring and its various modules. Technologu and Spring module used in this service are:

# Used Technologies
> - Spring Boot
> - H2 Database
> - Mongodb
> - JPA
> - Spring-Data
> - Spring-Data-JPA
> - Spring Data Rest
> - Spring-Web
> - Spring-Security
> - Junit
> - Logger
> - Swagger
> - JWT-Authentication


># Service having different version of same application, version and there description is below:

>## explorePlaces1-h2
- **Used Tech Stack :**
	JDK 11, Spring Boot, Spring-Web, JPA, Spring-Data, Spring-Data-JPA, Spring Data Rest, H2 Database


- **Application Description**

	- In this we implemented simple tour Microservice, using Spring web and Spring Data rest.
	- Exposed RestController with base URL "/tours/{tourId}/ratings", having different API for CRUD operation of TourRating service.
	- Used CommandLineRunner for:
		1. Extracted JSON file having to POJO using lambda having tour details.
		2. Create Tours.
		3. Create TourPackage.
				
	- Used JPA, Spring Data and Spring Data Rest for CrudRepository and PagingAndSortingRepository and mainly doing following operation:
		1. Exposed TourPackageRepository and TourRepository API's direct public access except Save and delete method. that means lookup methods are dircetly available to for http call using Spring Data rest.
		2. gave URI directly at "TourPackageRepository" as "package". means below link is directly accessible: http://localhost:8080/packages
		3. TourRepository extending PagingAndSortingRepository and there is no restriction on repo level access, that means paging, sorting other search URI http access is possible without exposing any direct API, like below:
			http://localhost:8080/tours/search/findByTourPackageCode?code=CC
			
			http://localhost:8080/tours?size=3&page=1&sort=title,asc
			
			http://localhost:8080/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc
			
			Save and delete API are restricted for direct http access.
		4. Restricted direct http access of TourRatingRepository, can be accessed by exposed API using RestServces or Microservices, implemented few custom repository methods.
	- Also implemented Service layer for TourService and TourPackageService.	
		


>## explorePlaces2-mongo



>## explorePlaces3-junt-swgr-lgr-h2



>## explorePlaces4-sSecurity-jwt-h2







