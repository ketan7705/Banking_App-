package com.revature.training.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.training.project.model.Customer;
import com.revature.training.project.model.Employee;
import com.revature.training.project.util.DBConnection;

public class EmployeeDAOImple implements EmployeeDAO{
	Connection connection = DBConnection.getDBConnection();
	
	private final String CREATE_EMPLOYEE_ACCOUNT_QUERY = "insert into hr.Employee values(?,?,?,?)";	
	private final String FIND_ALL_CUSTOMERS_QUERY = "select customerId,accountNUmber,customerName,dateOfBirth from hr.customers";
	private final String FIND_EMPLOYEE_BY_ID = "select * from hr.Employee where employeeId = ?";
	private final String DELETE_EMPLOYEE_BY_ID = "delete from hr.Employee where employeeId = ?";
	private final String DELETE_CUSTOMER_BY_ID = "delete from hr.customers where customerId = ?";
	
	
	@Override
	public boolean createAccount(Employee employee) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE_ACCOUNT_QUERY);
			statement.setInt(1,employee.getEmployeeId());
			statement.setString(2,employee.getEmployeeName());
			statement.setString(3,employee.getEmployeePassword());
			statement.setString(4, employee.getBranch());
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(FIND_ALL_CUSTOMERS_QUERY);
			while(res.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(res.getInt(1));
				customer.setAccountNumber(res.getInt(2));
				customer.setCustomerName(res.getString(3));
				customer.setDateOfBirth(res.getInt(4));
				
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public boolean isEmployeeExist(int employeeId) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			PreparedStatement stat = connection.prepareStatement(FIND_EMPLOYEE_BY_ID);
			stat.setInt(1, employeeId);
			ResultSet res = stat.executeQuery();

			if (res.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			PreparedStatement stat = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
			stat.setInt(1, employeeId);

			stat.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			PreparedStatement stat = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
			stat.setInt(1, customerId);

			stat.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	

}
