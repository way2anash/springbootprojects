package com.dictionary;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dictionary.services.DictionaryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dictionary.models.Dictionary;

@SpringBootApplication
public class DictionaryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DictionaryService dictionaryService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Dictionary>> typeReference = new TypeReference<List<Dictionary>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/dictionary.json");
			try {
				List<Dictionary> dictionary = mapper.readValue(inputStream,typeReference);
				dictionaryService.save(dictionary);
				System.out.println("Words Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Words: " + e.getMessage());
			}
		};
	}
	
}
