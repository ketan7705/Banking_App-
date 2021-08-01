package com.revature.training.project.WorldBank;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.training.project.dao.CustomerDAO;
import com.revature.training.project.dao.CutomerDAOImple;
import com.revature.training.project.dao.EmployeeDAO;
import com.revature.training.project.dao.EmployeeDAOImple;
import com.revature.training.project.model.Customer;
import com.revature.training.project.model.Employee;

public class EmployeePage {
	Employee employee = new Employee();
	boolean result;
	EmployeeDAO employeeDAO = new EmployeeDAOImple();
	CustomerDAO customerDAO = new CutomerDAOImple();
	Scanner sc = new Scanner(System.in);

	public void employeePage() {
		System.out.println("               ######! Successfully Login !######");
		System.out.println("Please select your choice.");
		System.out.println("1-  Check Customer Data");
		System.out.println("2-  Delete a Employee");
		System.out.println("3-  Delete a Customer");
		System.out.println("10- EXIT");

		try {
			int choice = sc.nextInt();
			if (choice <= 0) {
				System.out.println("##Enter Number only##");
			}

			switch (choice) {
			case 1:

				List<Customer> customers = employeeDAO.getAllCustomers();
				System.out.println("###Printing all the customers");
				System.out.println(customers);

				break;
			case 2:
				System.out.println("PLease enter employee ID to delete ");
				int employeeId = sc.nextInt();
				
				if (employeeDAO.isEmployeeExist(employeeId))
				{
					boolean resemployee = employeeDAO.deleteEmployee(employeeId);
					System.out.println(" Deleted Successfully with EmployeeID : "+employeeId);
				}
				else {
					System.out.println("!! Employee Doesn't Exists !!");
				}
				break;
			case 3 :
				System.out.println("PLease enter customer ID to delete ");
				int customerId = sc.nextInt();
				
				if (customerDAO.isCustomerExist(customerId))
				{
					boolean resemployee = employeeDAO.deleteCustomer(customerId);
					System.out.println(" Deleted Successfully with CustomerID : "+customerId);
				}
				else {
					System.out.println("!! Customer Doesn't Exists !!");
				}
				break;
				
			case 10:
				System.out.println("##Thanks for using my World Bank app##");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid choice");
			}
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("##Enter Number only##");
			System.out.println("Please select option again 1 to 4 & 10 for exit.");
		}
	}

}
