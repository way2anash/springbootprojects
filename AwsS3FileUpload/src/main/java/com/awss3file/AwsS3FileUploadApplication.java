package com.awss3file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.awss3file")

@SpringBootApplication
public class AwsS3FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsS3FileUploadApplication.class, args);
	}
}
