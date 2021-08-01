package com.revature.training.project.WorldBank;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.training.project.dao.CustomerDAO;
import com.revature.training.project.dao.CutomerDAOImple;
import com.revature.training.project.dao.EmployeeDAO;
import com.revature.training.project.dao.EmployeeDAOImple;
import com.revature.training.project.dao.UserDAO;
import com.revature.training.project.dao.UserDAOImple;
import com.revature.training.project.model.Customer;
import com.revature.training.project.model.Employee;
import com.revature.training.project.model.User;

public class Start {
	Customer customer = new Customer();
	Employee employee = new Employee();
	User user = new User();
	boolean result;
	CustomerDAO customerDAO = new CutomerDAOImple();
	EmployeeDAO employeeDAO = new EmployeeDAOImple();
	UserDAO userDAO = new UserDAOImple();
	Scanner sc = new Scanner(System.in);

	private static Logger logger = Logger.getLogger("ProductApp");

	public void startBankApp() {

		for (int i = 0; i < 10; i++) {

			System.out.println("               ######! Welcome to World Bank !######");
			System.out.println("Please select your choice.");
			System.out.println("1-  To Login");
			System.out.println("2-  Create Account");
			System.out.println("3-  About Banking app");
			System.out.println("4-  Contact us");
			System.out.println("10- EXIT");

			try {
				int choice = sc.nextInt();
				if (choice <= 0) {
					System.out.println("##Enter Number only##");
				}

				switch (choice) {
				case 1:
					logger.info("Your in Login Window : "+employee.getEmployeeName());
					System.out.println("Please select your choice which type of your account:  ");
					System.out.println("Enter 1 for Employee and 2 for Customer-- :");
					int choice2 = sc.nextInt();
					if (choice2 == 1) {
						user = addLogin();
						EmployeePage employeePage = new EmployeePage();
						employeePage.employeePage();

					} else if (choice2 == 2) {
						user = addLogin();
						UserPage userPage = new UserPage();
						userPage.userPage();

					} else {
						System.out.println("Your Choice is wrong");
					}
					logger.info("Exiting from login window");
					break;
				case 2:
					logger.info("Your in Create Account Window");
					System.out.println("   ##Wecome to World Bank , please enter your details to  create Account ##");
					System.out.println("Please select your choice which account you want create :  ");
					System.out.println("Enter 1 for Employee and 2 for Customer-- :");
					int choice1 = sc.nextInt();
					if (choice1 == 2) {
						customer = addCustomer();
						if (customerDAO.isCustomerExist(customer.getCustomerId()))
							logger.error("This Customer ID is already exists");
						else {
							result = customerDAO.createAccount(customer);
							if (result)
								logger.info("Account created successfully "+customer.getCustomerName());
							else
								System.out.println("Account not to be created,Please contact to the bank");
						}

					} else if (choice1 == 1) {
						employee = addEmployee();
						if (employeeDAO.isEmployeeExist(employee.getEmployeeId()))
							logger.error("This Employee ID is already exists");
						else {
							result = employeeDAO.createAccount(employee);
							if (result)
								logger.info("Account created successfully "+employee.getEmployeeName());
							else
								logger.error("Account not to be created,Please contact to the bank");
						}
					} else {
						System.out.println("Your Choice is wrong");
					}

					logger.info("Exiting from Account Section");
					break;
				case 3:
					System.out.println("!! All About world Bank !!");
					break;
				case 4:
					System.out.println(" Please Dial 100 to reach us..!!");
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

	public Customer addCustomer() {

		System.out.println("Enter your Customer ID : ");
		int customerId = sc.nextInt();
		System.out
				.println("Please enter your correct phone number this is your account number for future reference.!!");
		System.out.println("Enter your Phone Number : ");
		int accountNumber = sc.nextInt();
		System.out.println("Enter your Customer Name : ");
		String customerName = sc.next();
		System.out.println("Enter your Password : ");
		String customerPassword = sc.next();
		System.out.println("Enter your Age to Check Major/Minor : ");
		int dateOfBirth = sc.nextInt();
		System.out.println("Enter your address ");
		String address = sc.next();
		System.out.println("Deposit minimum 500Rs. to your account : ");
		int currentBalance = sc.nextInt();
		if(currentBalance < 500)
			System.out.println("Minimum balance should be 500Rs.");
		
		Customer customer = new Customer(customerId, accountNumber, customerName, customerPassword, dateOfBirth,
				address, currentBalance);
		return customer;
		
	}

	public Employee addEmployee() {

		System.out.println("Enter your Employee ID : ");
		int employeeId = sc.nextInt();
		System.out.println("Enter your Employee Name : ");
		String employeeName = sc.next();
		System.out.println("Enter your Password : ");
		String employeePassword = sc.next();
		System.out.println("Enter Your Branch : ");
		String branch = sc.next();

		Employee employee = new Employee(employeeId, employeeName, employeePassword, branch);
		return employee;
	}

	public User addLogin() {
		System.out.println("Enter your UserName : ");
		String userName = sc.next();
		System.out.println("Enter your Password : ");
		String userPassword = sc.next();

		User user = new User(0, userName, userPassword);
		return user;
	}

}
