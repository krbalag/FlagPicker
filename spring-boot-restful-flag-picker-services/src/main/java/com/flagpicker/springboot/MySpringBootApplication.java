package com.flagpicker.springboot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flagpicker.springboot.service.ContinentService;
import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Continents;


@SpringBootApplication(scanBasePackages={"com.flagpicker.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class MySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ContinentService continentService){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			//Continent continent = mapper.readValue(new File("/Users/balajiramakrishnan/Downloads/Download/eclipse-workspace/spring-boot-restful-flag-picker-services/src/main/resources/json/continents.json"), Continent.class);
	        //System.out.println(continent.toString());
			TypeReference<List<Continent>> typeReference = new TypeReference<List<Continent>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/continents.json");
			try {
				List<Continent> continent1 = mapper.readValue(inputStream,typeReference);
				//continentService.save(continents);
				System.out.println("continents Saved!" +continent1);
			} catch (IOException e){
				System.out.println("Unable to save continents: " + e.getMessage());
			}
	    };
	}
}
