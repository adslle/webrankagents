/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.wsr.jdbc;

import com.wsr.dao.*;
import com.wsr.factory.*;
import com.wsr.dto.*;
import com.wsr.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ServicecatServiceDaoImpl extends AbstractDAO implements ServicecatServiceDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT SCS_ID, SC_ID, service_ID FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( SCS_ID, SC_ID, service_ID ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET SCS_ID = ?, SC_ID = ?, service_ID = ? WHERE SCS_ID = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE SCS_ID = ?";

	/** 
	 * Index of column SCS_ID
	 */
	protected static final int COLUMN_SCS_ID = 1;

	/** 
	 * Index of column SC_ID
	 */
	protected static final int COLUMN_SC_ID = 2;

	/** 
	 * Index of column service_ID
	 */
	protected static final int COLUMN_SERVICE_ID = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column SCS_ID
	 */
	protected static final int PK_COLUMN_SCS_ID = 1;

	/** 
	 * Inserts a new row in the servicecat_service table.
	 */
	public ServicecatServicePk insert(ServicecatService dto) throws ServicecatServiceDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setInt( index++, dto.getScsId() );
			stmt.setInt( index++, dto.getScId() );
			stmt.setInt( index++, dto.getServiceId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
			return dto.createPk();
		}
		catch (Throwable _e) {
			throw new ServicecatServiceDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the servicecat_service table.
	 */
	public void update(ServicecatServicePk pk, ServicecatService dto) throws ServicecatServiceDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getScsId() );
			stmt.setInt( index++, dto.getScId() );
			stmt.setInt( index++, dto.getServiceId() );
			stmt.setInt( 4, pk.getScsId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Throwable _e) {
			throw new ServicecatServiceDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the servicecat_service table.
	 */
	public void delete(ServicecatServicePk pk) throws ServicecatServiceDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getScsId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Throwable _e) {
			throw new ServicecatServiceDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the servicecat_service table that matches the specified primary-key value.
	 */
	public ServicecatService findByPrimaryKey(ServicecatServicePk pk) throws ServicecatServiceDaoException
	{
		return findByPrimaryKey( pk.getScsId() );
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the criteria 'SCS_ID = :scsId'.
	 */
	public ServicecatService findByPrimaryKey(int scsId) throws ServicecatServiceDaoException
	{
		ServicecatService ret[] = findByDynamicSelect( SQL_SELECT + " WHERE SCS_ID = ?", new Object[] {  new Integer(scsId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the criteria ''.
	 */
	public ServicecatService[] findAll() throws ServicecatServiceDaoException
	{
		return findByDynamicSelect( SQL_SELECT, null );
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the criteria 'SCS_ID = :scsId'.
	 */
	public ServicecatService[] findWhereScsIdEquals(int scsId) throws ServicecatServiceDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE SCS_ID = ? ORDER BY SCS_ID", new Object[] {  new Integer(scsId) } );
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the criteria 'SC_ID = :scId'.
	 */
	public ServicecatService[] findWhereScIdEquals(int scId) throws ServicecatServiceDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE SC_ID = ? ORDER BY SC_ID", new Object[] {  new Integer(scId) } );
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the criteria 'service_ID = :serviceId'.
	 */
	public ServicecatService[] findWhereServiceIdEquals(int serviceId) throws ServicecatServiceDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE service_ID = ? ORDER BY service_ID", new Object[] {  new Integer(serviceId) } );
	}

	/**
	 * Method 'ServicecatServiceDaoImpl'
	 * 
	 */
	public ServicecatServiceDaoImpl()
	{
	}

	/**
	 * Method 'ServicecatServiceDaoImpl'
	 * 
	 * @param userConn
	 */
	public ServicecatServiceDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "webservicerank.servicecat_service";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ServicecatService fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ServicecatService dto = new ServicecatService();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ServicecatService[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ServicecatService dto = new ServicecatService();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ServicecatService ret[] = new ServicecatService[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ServicecatService dto, ResultSet rs) throws SQLException
	{
		dto.setScsId( rs.getInt( COLUMN_SCS_ID ) );
		dto.setScId( rs.getInt( COLUMN_SC_ID ) );
		dto.setServiceId( rs.getInt( COLUMN_SERVICE_ID ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ServicecatService dto)
	{
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the specified arbitrary SQL statement
	 */
	public ServicecatService[] findByDynamicSelect(String sql, Object[] sqlParams) throws ServicecatServiceDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Throwable _e) {
			throw new ServicecatServiceDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the servicecat_service table that match the specified arbitrary SQL statement
	 */
	public ServicecatService[] findByDynamicWhere(String sql, Object[] sqlParams) throws ServicecatServiceDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
			System.out.println(SQL);
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Throwable _e) {
			throw new ServicecatServiceDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
