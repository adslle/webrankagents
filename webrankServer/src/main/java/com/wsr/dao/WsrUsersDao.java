/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.wsr.dao;

import java.util.Date;
import com.wsr.dto.*;
import com.wsr.exceptions.*;

public interface WsrUsersDao
{
	/** 
	 * Inserts a new row in the wsr_users table.
	 */
	public WsrUsersPk insert(WsrUsers dto) throws WsrUsersDaoException;

	/** 
	 * Updates a single row in the wsr_users table.
	 */
	public void update(WsrUsersPk pk, WsrUsers dto) throws WsrUsersDaoException;

	/** 
	 * Deletes a single row in the wsr_users table.
	 */
	public void delete(WsrUsersPk pk) throws WsrUsersDaoException;

	/** 
	 * Returns the rows from the wsr_users table that matches the specified primary-key value.
	 */
	public WsrUsers findByPrimaryKey(WsrUsersPk pk) throws WsrUsersDaoException;

	/** 
	 * Returns all rows from the wsr_users table that match the criteria 'userid = :userid'.
	 */
	public WsrUsers findByPrimaryKey(int userid) throws WsrUsersDaoException;

	/** 
	 * Returns all rows from the wsr_users table that match the criteria ''.
	 */
	public WsrUsers[] findAll() throws WsrUsersDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the wsr_users table that match the specified arbitrary SQL statement
	 */
	public WsrUsers[] findByDynamicSelect(String sql, Object[] sqlParams) throws WsrUsersDaoException;

	/** 
	 * Returns all rows from the wsr_users table that match the specified arbitrary SQL statement
	 */
	public WsrUsers[] findByDynamicWhere(String sql, Object[] sqlParams) throws WsrUsersDaoException;

}
