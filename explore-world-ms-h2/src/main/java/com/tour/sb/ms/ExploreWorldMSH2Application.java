package com.tour.sb.ms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.sb.ms.domain.Difficulty;
import com.tour.sb.ms.domain.Region;
import com.tour.sb.ms.domain.TourPackage;
import com.tour.sb.ms.repo.TourPackageRepository;
import com.tour.sb.ms.service.TourPackageService;
import com.tour.sb.ms.service.TourService;

@SpringBootApplication
public class ExploreWorldMSH2Application implements CommandLineRunner {

	@Value("${ec.importfile}")
	private String importfile;

	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourPackageRepository tourPackageRepository;

	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreWorldMSH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createTourPackage();
		long numOfTourPackages = tourPackageService.total();

		List<TourPackage> savedNotesList = (List<TourPackage>) tourPackageRepository.findAll();
		System.out.println("\n######################    All Tour Package are below  ->   ##########################");
		savedNotesList.forEach(note -> {
			System.out.println(note.toString());
		});
		System.out.println("-----------------------Total TourPackage ::----------------------"+ numOfTourPackages);
		System.out.println("---------------------------------------------\n\n");



		createTours(importfile);
		long numOfTours = tourService.total();

	}

	/**
	 * 
	 */
	private void createTourPackage() {

		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot Springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");

	}

	/**
	 * @param importfile2
	 * @throws IOException
	 */
	private void createTours(String fileToImport) throws IOException {

		// TODO Auto-generated method stub
		/**
		 * Reading file fileToImport using read method of TourFromFile and holding data in "List<TourFromFile>", which is further passed to create tours
		 */
		TourFromFile.read(fileToImport)
		.forEach(importedTour -> tourService.createTour(importedTour.getTitle(), 
				importedTour.getDescription(),
				importedTour.getBlurb(), 
				importedTour.getPrice(), 
				importedTour.getLength(),
				importedTour.getBullets(), 
				importedTour.getKeywords(), 
				importedTour.getPackageType(),
				importedTour.getDifficulty(), 
				importedTour.getRegion()));
	}

	private static class TourFromFile {

		private String packageType;
		private String title;
		private String description;
		private String blurb;
		private String price;
		private String length;
		private String bullets;
		private String keywords;
		private String difficulty;
		private String region;

		static List<TourFromFile> read(String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
					.readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {
					});
		}

		protected TourFromFile() {
		}

		/**
		 * @return the packageType
		 */
		String getPackageType() {
			return packageType;
		}

		/**
		 * @return the title
		 */
		String getTitle() {
			return title;
		}

		/**
		 * @return the description
		 */
		String getDescription() {
			return description;
		}

		/**
		 * @return the blurb
		 */
		String getBlurb() {
			return blurb;
		}

		/**
		 * @return the price
		 */
		Integer getPrice() {
			return Integer.parseInt(price);
		}

		/**
		 * @return the length
		 */
		String getLength() {
			return length;
		}

		/**
		 * @return the bullets
		 */
		String getBullets() {
			return bullets;
		}

		/**
		 * @return the keywords
		 */
		String getKeywords() {
			return keywords;
		}

		/**
		 * @return the difficulty
		 */
		Difficulty getDifficulty() {
			return Difficulty.valueOf(difficulty);
		}

		/**
		 * @return the region
		 */
		Region getRegion() {
			return Region.findByLabel(region);
		}

	}

}
