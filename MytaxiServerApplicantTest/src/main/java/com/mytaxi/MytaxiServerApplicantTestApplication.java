package com.mytaxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MytaxiServerApplicantTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytaxiServerApplicantTestApplication.class, args);
	}
	
	 @Bean
	    public Docket docket()
	    {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(generateApiInfo());
	    }


	    private ApiInfo generateApiInfo()
	    {
	        return new ApiInfo("mytaxi Server Applicant Test Service", "Rest service for taxi api demo", "Version 0.1 - mw",
	            "urn:tos", "info@mytaxi.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	    }

}
