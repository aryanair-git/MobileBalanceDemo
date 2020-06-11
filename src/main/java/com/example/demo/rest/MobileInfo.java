/**
 * 
 */
package com.example.demo.rest;

import java.time.LocalDateTime;

/**
 * @author 202669
 *
 */
public class MobileInfo {

	private long mobileNo;
	
	private double calBalance;
	
	private double smsBalance;
	
	private double totalBalance;





	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the calBalance
	 */
	public double getCalBalance() {
		return calBalance;
	}

	/**
	 * @param calBalance the calBalance to set
	 */
	public void setCalBalance(double calBalance) {
		this.calBalance = calBalance;
	}

	/**
	 * @return the smsBalance
	 */
	public double getSmsBalance() {
		return smsBalance;
	}

	/**
	 * @param smsBalance the smsBalance to set
	 */
	public void setSmsBalance(double smsBalance) {
		this.smsBalance = smsBalance;
	}

	/**
	 * @return the totalBalance
	 */
	public double getTotalBalance() {
		return totalBalance;
	}

	/**
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "MobileInfo [mobileNo=" + mobileNo + ", calBalance=" + calBalance + ", smsBalance=" + smsBalance
				+ ", totalBalance=" + totalBalance
				+ "]";
	}

	/**
	 * @param mobileNo
	 * @param calBalance
	 * @param smsBalance
	 * @param totalBalance
	 */
	public MobileInfo(long mobileNo, double calBalance, double smsBalance, double totalBalance) {
		super();
		this.mobileNo = mobileNo;
		this.calBalance = calBalance;
		this.smsBalance = smsBalance;
		this.totalBalance = totalBalance;
	}

	/**
	 * 
	 */
	public MobileInfo() {
		super();
	}
	
	
}
