package com.revature.training.project.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.training.project.model.Customer;

public class CutomerDAOImpleTest {

	private CustomerDAO customerDAO;
	private EmployeeDAO employeeDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerDAO = new CutomerDAOImple();
		employeeDAO = new EmployeeDAOImple();
		
	}

	@After
	public void tearDown() throws Exception {
		customerDAO = null;
		employeeDAO = null;
	}

	@Test
	public void testCreateAccount() {
		int customerIdToTest = 100;
		
		Customer addedCustomer = new Customer(customerIdToTest,9867,"Prasad","qwerty@1234",22,"Austria",4000);
		customerDAO.createAccount(addedCustomer);
		employeeDAO.deleteCustomer(customerIdToTest);
		
	}

	@Test
	public void testViewBalance() {
		int customerIdToTest = 100;
		
		customerDAO.viewBalance(customerIdToTest);
		employeeDAO.deleteCustomer(customerIdToTest);
	}
	
	@Test
	public void testIsCustomerExist() {
		int customerIdToTest = 100;
		
		customerDAO.isCustomerExist(customerIdToTest);
	}


}
