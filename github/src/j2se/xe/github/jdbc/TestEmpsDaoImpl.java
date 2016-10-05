/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package j2se.xe.github.jdbc;

import j2se.xe.github.dao.*;
import j2se.xe.github.factory.*;
import java.util.Date;
import j2se.xe.github.dto.*;
import j2se.xe.github.exceptions.*;
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

public class TestEmpsDaoImpl extends AbstractDAO implements TestEmpsDao
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
	protected final String SQL_SELECT = "SELECT EMP_ID, EMP_NAME, EMP_SALARY, EMP_HIRE_DATE, EMP_ADDRESS, EMP_NID FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( EMP_ID, EMP_NAME, EMP_SALARY, EMP_HIRE_DATE, EMP_ADDRESS, EMP_NID ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET EMP_ID = ?, EMP_NAME = ?, EMP_SALARY = ?, EMP_HIRE_DATE = ?, EMP_ADDRESS = ?, EMP_NID = ? WHERE EMP_ID = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE EMP_ID = ?";

	/** 
	 * Index of column EMP_ID
	 */
	protected static final int COLUMN_EMP_ID = 1;

	/** 
	 * Index of column EMP_NAME
	 */
	protected static final int COLUMN_EMP_NAME = 2;

	/** 
	 * Index of column EMP_SALARY
	 */
	protected static final int COLUMN_EMP_SALARY = 3;

	/** 
	 * Index of column EMP_HIRE_DATE
	 */
	protected static final int COLUMN_EMP_HIRE_DATE = 4;

	/** 
	 * Index of column EMP_ADDRESS
	 */
	protected static final int COLUMN_EMP_ADDRESS = 5;

	/** 
	 * Index of column EMP_NID
	 */
	protected static final int COLUMN_EMP_NID = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column EMP_ID
	 */
	protected static final int PK_COLUMN_EMP_ID = 1;

	/** 
	 * Inserts a new row in the TEST_EMPS table.
	 */
	public TestEmpsPk insert(TestEmps dto) throws TestEmpsDaoException
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
			stmt.setInt( index++, dto.getEmpId() );
			stmt.setString( index++, dto.getEmpName() );
			if (dto.isEmpSalaryNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getEmpSalary() );
			}
		
			stmt.setTimestamp(index++, dto.getEmpHireDate()==null ? null : new java.sql.Timestamp( dto.getEmpHireDate().getTime() ) );
			stmt.setString( index++, dto.getEmpAddress() );
			stmt.setString( index++, dto.getEmpNid() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new TestEmpsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the TEST_EMPS table.
	 */
	public void update(TestEmpsPk pk, TestEmps dto) throws TestEmpsDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getEmpId() );
			stmt.setString( index++, dto.getEmpName() );
			if (dto.isEmpSalaryNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getEmpSalary() );
			}
		
			stmt.setTimestamp(index++, dto.getEmpHireDate()==null ? null : new java.sql.Timestamp( dto.getEmpHireDate().getTime() ) );
			stmt.setString( index++, dto.getEmpAddress() );
			stmt.setString( index++, dto.getEmpNid() );
			stmt.setInt( 7, pk.getEmpId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new TestEmpsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the TEST_EMPS table.
	 */
	public void delete(TestEmpsPk pk) throws TestEmpsDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getEmpId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new TestEmpsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the TEST_EMPS table that matches the specified primary-key value.
	 */
	public TestEmps findByPrimaryKey(TestEmpsPk pk) throws TestEmpsDaoException
	{
		return findByPrimaryKey( pk.getEmpId() );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ID = :empId'.
	 */
	public TestEmps findByPrimaryKey(int empId) throws TestEmpsDaoException
	{
		TestEmps ret[] = findByDynamicSelect( SQL_SELECT + " WHERE EMP_ID = ?", new Object[] {  new Integer(empId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria ''.
	 */
	public TestEmps[] findAll() throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY EMP_ID", null );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ID = :empId'.
	 */
	public TestEmps[] findWhereEmpIdEquals(int empId) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_ID = ? ORDER BY EMP_ID", new Object[] {  new Integer(empId) } );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_NAME = :empName'.
	 */
	public TestEmps[] findWhereEmpNameEquals(String empName) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_NAME = ? ORDER BY EMP_NAME", new Object[] { empName } );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_SALARY = :empSalary'.
	 */
	public TestEmps[] findWhereEmpSalaryEquals(int empSalary) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_SALARY = ? ORDER BY EMP_SALARY", new Object[] {  new Integer(empSalary) } );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_HIRE_DATE = :empHireDate'.
	 */
	public TestEmps[] findWhereEmpHireDateEquals(Date empHireDate) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_HIRE_DATE = ? ORDER BY EMP_HIRE_DATE", new Object[] { empHireDate==null ? null : new java.sql.Timestamp( empHireDate.getTime() ) } );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ADDRESS = :empAddress'.
	 */
	public TestEmps[] findWhereEmpAddressEquals(String empAddress) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_ADDRESS = ? ORDER BY EMP_ADDRESS", new Object[] { empAddress } );
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_NID = :empNid'.
	 */
	public TestEmps[] findWhereEmpNidEquals(String empNid) throws TestEmpsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE EMP_NID = ? ORDER BY EMP_NID", new Object[] { empNid } );
	}

	/**
	 * Method 'TestEmpsDaoImpl'
	 * 
	 */
	public TestEmpsDaoImpl()
	{
	}

	/**
	 * Method 'TestEmpsDaoImpl'
	 * 
	 * @param userConn
	 */
	public TestEmpsDaoImpl(final java.sql.Connection userConn)
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
		return "GITHUB.TEST_EMPS";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected TestEmps fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			TestEmps dto = new TestEmps();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected TestEmps[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			TestEmps dto = new TestEmps();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		TestEmps ret[] = new TestEmps[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(TestEmps dto, ResultSet rs) throws SQLException
	{
		dto.setEmpId( rs.getInt( COLUMN_EMP_ID ) );
		dto.setEmpName( rs.getString( COLUMN_EMP_NAME ) );
		dto.setEmpSalary( rs.getInt( COLUMN_EMP_SALARY ) );
		if (rs.wasNull()) {
			dto.setEmpSalaryNull( true );
		}
		
		dto.setEmpHireDate( rs.getTimestamp(COLUMN_EMP_HIRE_DATE ) );
		dto.setEmpAddress( rs.getString( COLUMN_EMP_ADDRESS ) );
		dto.setEmpNid( rs.getString( COLUMN_EMP_NID ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(TestEmps dto)
	{
	}

	/** 
	 * Returns all rows from the TEST_EMPS table that match the specified arbitrary SQL statement
	 */
	public TestEmps[] findByDynamicSelect(String sql, Object[] sqlParams) throws TestEmpsDaoException
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
		
		
			System.out.println( "Executing " + SQL );
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
		catch (Exception _e) {
			_e.printStackTrace();
			throw new TestEmpsDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the TEST_EMPS table that match the specified arbitrary SQL statement
	 */
	public TestEmps[] findByDynamicWhere(String sql, Object[] sqlParams) throws TestEmpsDaoException
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
		
		
			System.out.println( "Executing " + SQL );
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
		catch (Exception _e) {
			_e.printStackTrace();
			throw new TestEmpsDaoException( "Exception: " + _e.getMessage(), _e );
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
