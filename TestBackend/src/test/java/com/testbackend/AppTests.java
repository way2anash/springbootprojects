package com.testbackend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

	 @Autowired
	    private DataServServices dataServServices;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
    public void testDataService() {
		
		dataServServices.saveData(new DataService(1,"First term"));
		dataServServices.saveData(new DataService(2,"Second term"));
		dataServServices.saveData(new DataService(3,"Another term"));
		dataServServices.saveData(new DataService(4,"Miscellaneous term"));
		dataServServices.saveData(new DataService(5,""));
		
		int numOfDatas = dataServServices.findAll().size();
		assertEquals(numOfDatas, 5);
		
		
	}

}
