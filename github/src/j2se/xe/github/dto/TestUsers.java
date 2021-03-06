/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package j2se.xe.github.dto;

import j2se.xe.github.dao.*;
import j2se.xe.github.factory.*;
import j2se.xe.github.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class TestUsers implements Serializable
{
	/** 
	 * This attribute maps to the column USER_ID in the TEST_USERS table.
	 */
	protected int userId;

	/** 
	 * This attribute maps to the column USER_NAME in the TEST_USERS table.
	 */
	protected String userName;

	/** 
	 * This attribute maps to the column USER_ADDRESS in the TEST_USERS table.
	 */
	protected String userAddress;

	/** 
	 * This attribute maps to the column USER_MOBILE in the TEST_USERS table.
	 */
	protected String userMobile;

	/** 
	 * This attribute maps to the column USER_HIRE_DATE in the TEST_USERS table.
	 */
	protected Date userHireDate;

	/** 
	 * This attribute maps to the column USER_DESCRIPTION in the TEST_USERS table.
	 */
	protected String userDescription;

	/**
	 * Method 'TestUsers'
	 * 
	 */
	public TestUsers()
	{
	}

	/**
	 * Method 'getUserId'
	 * 
	 * @return int
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Method 'setUserId'
	 * 
	 * @param userId
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Method 'getUserName'
	 * 
	 * @return String
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Method 'setUserName'
	 * 
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * Method 'getUserAddress'
	 * 
	 * @return String
	 */
	public String getUserAddress()
	{
		return userAddress;
	}

	/**
	 * Method 'setUserAddress'
	 * 
	 * @param userAddress
	 */
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	/**
	 * Method 'getUserMobile'
	 * 
	 * @return String
	 */
	public String getUserMobile()
	{
		return userMobile;
	}

	/**
	 * Method 'setUserMobile'
	 * 
	 * @param userMobile
	 */
	public void setUserMobile(String userMobile)
	{
		this.userMobile = userMobile;
	}

	/**
	 * Method 'getUserHireDate'
	 * 
	 * @return Date
	 */
	public Date getUserHireDate()
	{
		return userHireDate;
	}

	/**
	 * Method 'setUserHireDate'
	 * 
	 * @param userHireDate
	 */
	public void setUserHireDate(Date userHireDate)
	{
		this.userHireDate = userHireDate;
	}

	/**
	 * Method 'getUserDescription'
	 * 
	 * @return String
	 */
	public String getUserDescription()
	{
		return userDescription;
	}

	/**
	 * Method 'setUserDescription'
	 * 
	 * @param userDescription
	 */
	public void setUserDescription(String userDescription)
	{
		this.userDescription = userDescription;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof TestUsers)) {
			return false;
		}
		
		final TestUsers _cast = (TestUsers) _other;
		if (userId != _cast.userId) {
			return false;
		}
		
		if (userName == null ? _cast.userName != userName : !userName.equals( _cast.userName )) {
			return false;
		}
		
		if (userAddress == null ? _cast.userAddress != userAddress : !userAddress.equals( _cast.userAddress )) {
			return false;
		}
		
		if (userMobile == null ? _cast.userMobile != userMobile : !userMobile.equals( _cast.userMobile )) {
			return false;
		}
		
		if (userHireDate == null ? _cast.userHireDate != userHireDate : !userHireDate.equals( _cast.userHireDate )) {
			return false;
		}
		
		if (userDescription == null ? _cast.userDescription != userDescription : !userDescription.equals( _cast.userDescription )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + userId;
		if (userName != null) {
			_hashCode = 29 * _hashCode + userName.hashCode();
		}
		
		if (userAddress != null) {
			_hashCode = 29 * _hashCode + userAddress.hashCode();
		}
		
		if (userMobile != null) {
			_hashCode = 29 * _hashCode + userMobile.hashCode();
		}
		
		if (userHireDate != null) {
			_hashCode = 29 * _hashCode + userHireDate.hashCode();
		}
		
		if (userDescription != null) {
			_hashCode = 29 * _hashCode + userDescription.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return TestUsersPk
	 */
	public TestUsersPk createPk()
	{
		return new TestUsersPk(userId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "j2se.xe.github.dto.TestUsers: " );
		ret.append( "userId=" + userId );
		ret.append( ", userName=" + userName );
		ret.append( ", userAddress=" + userAddress );
		ret.append( ", userMobile=" + userMobile );
		ret.append( ", userHireDate=" + userHireDate );
		ret.append( ", userDescription=" + userDescription );
		return ret.toString();
	}

}
