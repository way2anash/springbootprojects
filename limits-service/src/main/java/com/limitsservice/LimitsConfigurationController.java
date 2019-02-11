package com.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.limitsservice.bean.LimitConfiguration;



@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration config;
	
	 @Value("${message:Hello default}")
	    private String message;

	    @RequestMapping("/message")
	    String getMessage() {
	        return this.message;
	    }
	
	@GetMapping("/limits")
	public LimitConfiguration retrievalLimitsFromConfigurations() {
		
	 return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
	
}
