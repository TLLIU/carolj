package com.tlliu.springboot.carolj;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tlliu.springboot.carolj.config.BuildInfoConfigurationManager;
import com.tlliu.springboot.carolj.model.Country;
import com.tlliu.springboot.carolj.repository.CountryRepository;

@SpringBootApplication
public class CaroljApplication {
	private static Logger logger = LoggerFactory.getLogger(CaroljApplication.class);

	// @Autowired
	// CountryRepository countryRepo;

	public static void main(String[] args) {
		SpringApplication.run(CaroljApplication.class, args);

		BuildInfoConfigurationManager.getInstance().loadBuildInfoConfiguration();
	}

	@PostConstruct
	private void initDB() {
		// Country country = new Country();
		// country.setName("China");
		// Country saved = countryRepo.save(country);
        // logger.info("Saved country info {}: {}", saved.getId(), saved.getName());

	}

}
