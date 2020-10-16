package com.tour.sb.ms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.sb.ms.domain.TourPackage;
import com.tour.sb.ms.repo.TourPackageRepository;
import com.tour.sb.ms.service.TourPackageService;
import com.tour.sb.ms.service.TourService;

@SpringBootApplication
public class ExploreWorldMSMongoApplication implements CommandLineRunner {

	@Value("${ec.importfile}")
	private String importfile;

	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourPackageRepository tourPackageRepository;

	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreWorldMSMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createTourAllPackages();

		List<TourPackage> savedNotesList = (List<TourPackage>) tourPackageRepository.findAll();
		System.out.println("\n######################    All Tour Package are below  ->   ##########################");
		savedNotesList.forEach(note -> {
			System.out.println(note.toString());
		});
		System.out.println("---------------------------------------------\n\n");

		createTours(importfile);
	}

	/**
	 * Initialize all the known tour packages
	 */
	private void createTourAllPackages() {

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
	 * Create tour entities from an external file
	 * 
	 * @param importfile2
	 * @throws IOException
	 */
	private void createTours(String fileToImport) throws IOException {

		// TODO Auto-generated method stub
		TourFromFile.read(fileToImport)
					.forEach(tourFromFile -> tourService.createTour(tourFromFile.getTitle(),
							tourFromFile.getPackageName(), tourFromFile.getDetails()));
	}

    /**
     * Helper class to import ExploreCalifornia.json for a MongoDb Document.
     * Only interested in the title and package name, the remaining fields
     * are a collection of key-value pairs
     *
     */
	private static class TourFromFile {

		private String title;
		private String packageName;
		private Map<String, String> details;


		TourFromFile(Map<String, String> record) {
			this.title = record.get("title");
			this.packageName = record.get("packageType");
			this.details = record;
			this.details.remove("packageType");
			this.details.remove("title");
		}

		/**
		 * Reader
		 * 
		 * @param fileToImport
		 * @return
		 * @throws IOException
		 */
		static List<TourFromFile> read(String fileToImport) throws IOException {

			List<Map<String, String>> records = new ObjectMapper()
					.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
					.readValue(new FileInputStream(fileToImport), 
							new TypeReference<List<Map<String, String>>>() {	});

			return records.stream().map(TourFromFile::new).collect(Collectors.toList());
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @return the packageName
		 */
		public String getPackageName() {
			return packageName;
		}

		/**
		 * @return the details
		 */
		public Map<String, String> getDetails() {
			return details;
		}

	}

}
