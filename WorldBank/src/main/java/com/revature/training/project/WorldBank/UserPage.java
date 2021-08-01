package com.revature.training.project.WorldBank;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.training.project.dao.CustomerDAO;
import com.revature.training.project.dao.CutomerDAOImple;
import com.revature.training.project.model.Customer;

public class UserPage {
	Customer customer = new Customer();
	boolean result;
	CustomerDAO customerDAO = new CutomerDAOImple();
	Scanner sc = new Scanner(System.in);

	public void userPage() {

		System.out.println("               ######! Successfully Login !######");
		System.out.println("Please select your choice.");
		System.out.println("1-  Deposit Money ");
		System.out.println("2-  Withdraw Money ");
		System.out.println("3-  Transfer Money ");
		System.out.println("4-  View Balance ");
		System.out.println("10- EXIT");

		try {
			int choice = sc.nextInt();
			if (choice <= 0) {
				System.out.println("##Enter Number only##");
			}

			switch (choice) {
			case 1:

				result = customerDAO.depositMoney(customer);
				if (result)
					System.out.println("Your money Deposited successfully ");
				else
					System.out.println("Unable to deposit money, Please contact to bank..!!");
				break;
			case 2:
				result = customerDAO.withdrawMoney(customer);
				if (result)
					System.out.println(" Your money Withdrawal successfully ");
				else
					System.out.println("Unable to withdraw money, Please contact to bank..!!");
				break;
			case 3:
				result = customerDAO.transferMoney(customer);
				if (result)
					System.out.println(" Your money Transfer successfully ");
				else
					System.out.println("Unable to withdraw money, Please contact to bank..!!");
				break;
			case 4:
				System.out.println("Enter & Confirm your Customer ID. : ");
				int customerId = sc.nextInt();
				result = customerDAO.viewBalance(customerId);
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
