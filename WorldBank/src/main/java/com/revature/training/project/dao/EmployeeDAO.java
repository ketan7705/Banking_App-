package com.revature.training.project.dao;

import java.util.List;

import com.revature.training.project.model.Customer;
import com.revature.training.project.model.Employee;


public interface EmployeeDAO {
	public boolean createAccount(Employee employee);
	public List<Customer> getAllCustomers();
	public boolean isEmployeeExist(int employeeId);
	public boolean deleteEmployee(int employeeId);
	public boolean deleteCustomer(int customerId);
}