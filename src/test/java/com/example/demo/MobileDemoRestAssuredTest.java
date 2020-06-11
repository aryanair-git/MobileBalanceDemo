/**
 * 
 */
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


/**
 * @author 202669
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MobileDemoApplication.class} )
public class MobileDemoRestAssuredTest {

	@Value("${server.port}")
	private int port;
	
	@Test
	public void phoneBalanceCheckTest() throws JsonProcessingException {
		long mobileNo = 9876543212l;
		RestAssured.baseURI = "http://localhost:" + port;
		RequestSpecification request = RestAssured.given();			
		  Response response =  request.request(Method.GET,"/getBalances?mobile_no="+mobileNo);
		  System.out.println(response.getStatusCode());
		  System.out.println(response.jsonPath().getLong("mobileNo"));
		  Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		  Assert.assertEquals(mobileNo, response.jsonPath().getLong("mobileNo"));
			 		 
	}
	
	
}
