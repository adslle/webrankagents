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
 * This class represents the primary key of the service_property table.
 */
public class ServicePropertyPk implements Serializable
{
	protected int spId;

	/** 
	 * This attribute represents whether the primitive attribute spId is null.
	 */
	protected boolean spIdNull;

	/** 
	 * Sets the value of spId
	 */
	public void setSpId(int spId)
	{
		this.spId = spId;
	}

	/** 
	 * Gets the value of spId
	 */
	public int getSpId()
	{
		return spId;
	}

	/**
	 * Method 'ServicePropertyPk'
	 * 
	 */
	public ServicePropertyPk()
	{
	}

	/**
	 * Method 'ServicePropertyPk'
	 * 
	 * @param spId
	 */
	public ServicePropertyPk(final int spId)
	{
		this.spId = spId;
	}

	/** 
	 * Sets the value of spIdNull
	 */
	public void setSpIdNull(boolean spIdNull)
	{
		this.spIdNull = spIdNull;
	}

	/** 
	 * Gets the value of spIdNull
	 */
	public boolean isSpIdNull()
	{
		return spIdNull;
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
		
		if (!(_other instanceof ServicePropertyPk)) {
			return false;
		}
		
		final ServicePropertyPk _cast = (ServicePropertyPk) _other;
		if (spId != _cast.spId) {
			return false;
		}
		
		if (spIdNull != _cast.spIdNull) {
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
		_hashCode = 29 * _hashCode + spId;
		_hashCode = 29 * _hashCode + (spIdNull ? 1 : 0);
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
		ret.append( "com.wsr.dto.ServicePropertyPk: " );
		ret.append( "spId=" + spId );
		return ret.toString();
	}

}
