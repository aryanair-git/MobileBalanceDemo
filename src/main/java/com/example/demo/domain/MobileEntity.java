package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 202669
 *
 */
@Entity
@Table(name = "Mobile_Data")
public class MobileEntity {

	@Id
	@Column(name = "column_id")
	int columnId;
	
	@Column(name = "mobile_no")
	long mobileNo;
	
	@Column(name = "cal_balance")
	double calBalance;
	
	@Column(name = "sms_balance")
	double smsBalance;
	
	@Column(name = "created_time",updatable = false)
	LocalDateTime createdTime;
	
	@Column(name = "updated_time",updatable = true)
	LocalDateTime updatedTime;
	
	
	/**
	 * @return the columnId
	 */
	public int getColumnId() {
		return columnId;
	}

	/**
	 * @param columnId the columnId to set
	 */
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

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
	 * @return the createdTime
	 */
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the updatedTime
	 */
	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "MobileEntity [columnId=" + columnId + ", mobileNo=" + mobileNo + ", calBalance=" + calBalance
				+ ", smsBalance=" + smsBalance + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

	public MobileEntity() {
		super();
	}
	
	public MobileEntity(int columnId, int mobileNo, double calBalance, double smsBalance, LocalDateTime createdTime,
			LocalDateTime updatedTime) {
		super();
		this.columnId = columnId;
		this.mobileNo = mobileNo;
		this.calBalance = calBalance;
		this.smsBalance = smsBalance;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	
}
