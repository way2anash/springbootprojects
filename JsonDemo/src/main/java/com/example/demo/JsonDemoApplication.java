package com.example.demo;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JsonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonDemoApplication.class, args);
		
		/* ObjectMapper mapper = new ObjectMapper();
        try {
            Post usrPost = mapper.readValue(new URL("http://jsonplaceholder.typicode.com/posts/7"), Post.class);
            System.out.println(usrPost);
            System.out.println(".............................................");
            System.out.println(usrPost.getUserId());
            System.out.println(usrPost.getId());
            System.out.println(usrPost.getTitle());
            System.out.println(usrPost.getBody());    
        } catch (IOException e) 
            // TODO Auto-generated catch block
            e.printStackTrace();
        }         */
		
		ObjectMapper mapper = new ObjectMapper();
        try {
            IpLocation ipLoc = mapper.readValue(new URL("http://ip-api.com/json"), IpLocation.class);
          //  System.out.println(usrPost);
            System.out.println(".............................................");
             System.out.println(ipLoc.getAs());
             System.out.println(ipLoc.getCity());
            System.out.println(ipLoc.getLat());
            System.out.println(ipLoc.getLon());
            
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
