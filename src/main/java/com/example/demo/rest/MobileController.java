/**
 * 
 */
package com.example.demo.rest;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.MobileEntity;
import com.example.demo.service.MobileService;
import com.example.demo.service.exception.MobileServiceException;

/**
 * @author 202669
 *
 */
@RestController
public class MobileController {
	@Autowired
	private MobileService mobileService;

	@GetMapping(value="/getBalances")
	public MobileInfo getBalanceValues(@RequestParam(name = "mobile_no") long mobile_no){
		
		try {
			MobileInfo phnInfo = mobileService.getPhoneDetails(mobile_no);
			return phnInfo;
		}catch(MobileServiceException ex) {	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,ex.getMessage());
		}
			
	}
}
