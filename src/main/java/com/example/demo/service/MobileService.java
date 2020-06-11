/**
 * 
 */
package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MobileEntity;
import com.example.demo.domain.MobileRepository;
import com.example.demo.rest.MobileInfo;
import com.example.demo.service.exception.MobileServiceException;

/**
 * @author 202669
 *
 */
@Service
public class MobileService  {
	
	@Autowired
	private MobileRepository mobileRepo;
	
	/**
	 * Method to get Phone details
	 *
	 */
	public MobileInfo getPhoneDetails(long mobileNo) throws MobileServiceException {
		Optional<MobileEntity> phnDetails= mobileRepo.getMobileDetails(mobileNo);
		if(phnDetails.isPresent()) {
			MobileEntity mobileData = phnDetails.get();
			double totalBalance = mobileData.getCalBalance() + mobileData.getSmsBalance();
			MobileInfo mobileInfo = new MobileInfo(mobileNo, mobileData.getCalBalance(), mobileData.getSmsBalance(), totalBalance);			
			return mobileInfo;			
		}else {
			throw new MobileServiceException("Invalid Mobile Number");
		}
	}
}
