package com.revature.training.project.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.training.project.model.Customer;
import com.revature.training.project.model.Employee;

public class EmployeeDAOImpleTest {
	
	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeDAO = new EmployeeDAOImple();
		customerDAO = new CutomerDAOImple();
	}

	@After
	public void tearDown() throws Exception {
		employeeDAO = null;
		customerDAO = null;
	}

	@Test
	public void testCreateAccount() {
		int employeeIdToTest = 100;
		Employee adddedEmployee = new Employee(employeeIdToTest,"Mayuresh","qwerty@123","New York");
		employeeDAO.createAccount(adddedEmployee);
		
		employeeDAO.deleteEmployee(employeeIdToTest);
		
	}

	@Test
	public void testGetAllCustomers() {
		List<Customer> customer1 = employeeDAO.getAllCustomers();
		
	}

	@Test
	public void testIsEmployeeExist() {
		int employeeIdToTest = 100;
		employeeDAO.isEmployeeExist(employeeIdToTest);
	}
	
	@Test
	public void testDeleteEmployee() {
		int employeeIdToTest = 100;
		employeeDAO.deleteEmployee(employeeIdToTest);
	}

	@Test
	public void testDeleteCustomer() {
		int customerIdToTest = 100;
		
		Customer addedCustomer = new Customer(customerIdToTest,9867,"Prasad","qwerty@1234",22,"Austria",4000);
		customerDAO.createAccount(addedCustomer);
		employeeDAO.deleteCustomer(customerIdToTest);
	}

}
