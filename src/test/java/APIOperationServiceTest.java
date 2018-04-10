import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.operation.APIApplication;
import com.operation.service.APIOperationService;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Ashish Subandh 
 */


public class APIOperationServiceTest {
	@Autowired
	APIOperationService mos;

    @Test
    public void testScaleneTriangle() {
    	APIOperationService mos=new APIOperationService();
   assertEquals("scalene",mos.getTriangleType(1,2,3));
    }

    @Test
    public void testEquilateralTriangle() {
    	APIOperationService mos=new APIOperationService();
   assertEquals("equilateral",mos.getTriangleType(1,1,1));
    }

    @Test
    public void testIsoscelesTriangle() {
    	APIOperationService mos=new APIOperationService();
   assertEquals("isosceles",mos.getTriangleType(1,2,2));
    }

    @Test
    public void testFibonnaciSeries() {
    	long no=APIOperationService.fib(10);
    	assertEquals(34,no);

    }
    @Test
    public void testRevereseString() {
    	APIOperationService mos=new APIOperationService();
   assertEquals("erehW era uoy gniog",mos.reverseWordInMyString("Where are you going"));
    }

    
}
