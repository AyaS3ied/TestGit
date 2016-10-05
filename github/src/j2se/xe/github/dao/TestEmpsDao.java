/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package j2se.xe.github.dao;

import java.util.Date;
import j2se.xe.github.dto.*;
import j2se.xe.github.exceptions.*;

public interface TestEmpsDao
{
	/** 
	 * Inserts a new row in the TEST_EMPS table.
	 */
	public TestEmpsPk insert(TestEmps dto) throws TestEmpsDaoException;

	/** 
	 * Updates a single row in the TEST_EMPS table.
	 */
	public void update(TestEmpsPk pk, TestEmps dto) throws TestEmpsDaoException;

	/** 
	 * Deletes a single row in the TEST_EMPS table.
	 */
	public void delete(TestEmpsPk pk) throws TestEmpsDaoException;

	/** 
	 * Returns the rows from the TEST_EMPS table that matches the specified primary-key value.
	 */
	public TestEmps findByPrimaryKey(TestEmpsPk pk) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ID = :empId'.
	 */
	public TestEmps findByPrimaryKey(int empId) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria ''.
	 */
	public TestEmps[] findAll() throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ID = :empId'.
	 */
	public TestEmps[] findWhereEmpIdEquals(int empId) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_NAME = :empName'.
	 */
	public TestEmps[] findWhereEmpNameEquals(String empName) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_SALARY = :empSalary'.
	 */
	public TestEmps[] findWhereEmpSalaryEquals(int empSalary) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_HIRE_DATE = :empHireDate'.
	 */
	public TestEmps[] findWhereEmpHireDateEquals(Date empHireDate) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_ADDRESS = :empAddress'.
	 */
	public TestEmps[] findWhereEmpAddressEquals(String empAddress) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the criteria 'EMP_NID = :empNid'.
	 */
	public TestEmps[] findWhereEmpNidEquals(String empNid) throws TestEmpsDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the TEST_EMPS table that match the specified arbitrary SQL statement
	 */
	public TestEmps[] findByDynamicSelect(String sql, Object[] sqlParams) throws TestEmpsDaoException;

	/** 
	 * Returns all rows from the TEST_EMPS table that match the specified arbitrary SQL statement
	 */
	public TestEmps[] findByDynamicWhere(String sql, Object[] sqlParams) throws TestEmpsDaoException;

}
