/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.wsr.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the wsr_users table.
 */
public class WsrUsersPk implements Serializable
{
	protected int userid;

	/** 
	 * This attribute represents whether the primitive attribute userid is null.
	 */
	protected boolean useridNull;

	/** 
	 * Sets the value of userid
	 */
	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	/** 
	 * Gets the value of userid
	 */
	public int getUserid()
	{
		return userid;
	}

	/**
	 * Method 'WsrUsersPk'
	 * 
	 */
	public WsrUsersPk()
	{
	}

	/**
	 * Method 'WsrUsersPk'
	 * 
	 * @param userid
	 */
	public WsrUsersPk(final int userid)
	{
		this.userid = userid;
	}

	/** 
	 * Sets the value of useridNull
	 */
	public void setUseridNull(boolean useridNull)
	{
		this.useridNull = useridNull;
	}

	/** 
	 * Gets the value of useridNull
	 */
	public boolean isUseridNull()
	{
		return useridNull;
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
		
		if (!(_other instanceof WsrUsersPk)) {
			return false;
		}
		
		final WsrUsersPk _cast = (WsrUsersPk) _other;
		if (userid != _cast.userid) {
			return false;
		}
		
		if (useridNull != _cast.useridNull) {
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
		_hashCode = 29 * _hashCode + userid;
		_hashCode = 29 * _hashCode + (useridNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.wsr.dto.WsrUsersPk: " );
		ret.append( "userid=" + userid );
		return ret.toString();
	}

}
