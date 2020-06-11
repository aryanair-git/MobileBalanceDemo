package com.example.demo;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.rest.MobileController;
import com.example.demo.rest.MobileInfo;
import com.example.demo.service.MobileService;
import com.example.demo.service.exception.MobileServiceException;

import junit.framework.Assert;



/**
 * @author 202669
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MobileDemoApplication.class} )
@AutoConfigureMockMvc
public class MobileDemoSpringBootTest {
	

	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private MobileService mobileService;
	
	@InjectMocks
	private MobileController mobileController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mobileController).build();
	}
	
	/**
	 * Test success scenario
	 *
	 */
	@Test
	public void mobileDataTest() throws Exception {
		long mobileNo = 9847654232l;
		Mockito.when(mobileService.getPhoneDetails(mobileNo)).thenReturn(constructMockSuccessResult(mobileNo));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getBalances?mobile_no="+mobileNo);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String responseBody = response.getContentAsString();		
		JSONObject jObject = new JSONObject(responseBody);
		
		Assert.assertNotNull(jObject);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals(mobileNo, jObject.getLong("mobileNo"));	
		
	}
	
	/**
	 * Test failure scenario
	 *
	 */
	@Test
	public void mobileDataExceptionTest() throws Exception {
		long mobileNo = 98476542320l;
		Mockito.when(mobileService.getPhoneDetails(mobileNo)).thenThrow(new MobileServiceException("Invalid Mobile Number"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getBalances?mobile_no="+mobileNo);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		Assert.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		Assert.assertEquals("Invalid Mobile Number", response.getErrorMessage());			
	}
	
	
	private MobileInfo constructMockSuccessResult(long mobileNo) {
		MobileInfo mobileInfo = new MobileInfo(mobileNo, 10.00, 20.00, 30.00);
		return mobileInfo;
	}
}
