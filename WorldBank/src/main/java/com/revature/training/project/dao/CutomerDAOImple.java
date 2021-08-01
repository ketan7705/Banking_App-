package com.revature.training.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.revature.training.project.exception.InvalidAmountException;
import com.revature.training.project.model.Customer;
import com.revature.training.project.model.User;
import com.revature.training.project.util.DBConnection;

public class CutomerDAOImple implements CustomerDAO {
	Connection connection = DBConnection.getDBConnection();

	private final String CREATE_ACCOUNT_QUERY = "insert into hr.customers values(?,?,?,?,?,?,?)";
	private final String DEPOSIT_MONEY_QUERY = "update hr.customers set currentBalance = currentBalance + ? where customerId = ?  ";
	private final String WITHDRAW_MONEY_QUERY = "update hr.customers set currentBalance = currentBalance - ? where customerId = ? ";
	private final String VIEW_BALANCE_QUERY = "select currentBalance from hr.customers where customerId = ?";
	private final String FIND_CUSTOMER_BY_ID = "select * from hr.customers where customerId = ?";

	@Override
	public boolean createAccount(Customer customer) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(CREATE_ACCOUNT_QUERY);
			statement.setInt(1, customer.getCustomerId());
			statement.setInt(2, customer.getAccountNumber());
			statement.setString(3, customer.getCustomerName());
			statement.setString(4, customer.getCustomerPassword());
			statement.setInt(5, customer.getDateOfBirth());
			statement.setString(6, customer.getAddress());
			statement.setInt(7, customer.getCurrentBalance());

			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean depositMoney(Customer customer) throws InvalidAmountException {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		System.out.println("Enter your Amount to deposit in your account : ");
		int amount = sc.nextInt();
		if (amount < 0)
			throw new InvalidAmountException("You cannot deposit money in negative");
		System.out.println("Enter your Customer ID : ");
		int customerId = sc.nextInt();

		try {
			PreparedStatement statement = connection.prepareStatement(DEPOSIT_MONEY_QUERY);
			statement.setInt(1, amount);
			statement.setInt(2, customerId);

			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InvalidAmountException e1) {
			System.out.println(e1.getMessage());
		}
		// TODO Auto-generated method stub
		if (res == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean withdrawMoney(Customer customer) throws InvalidAmountException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int res = 0;
		System.out.println("Enter Amount to withdraw in your account : ");
		int amount = sc.nextInt();
		if (amount < 0)
			throw new InvalidAmountException("You cannot withdraw money in negative");
		System.out.println("Enter your Customer ID : ");
		int customerId = sc.nextInt();

		try {
			PreparedStatement statement = connection.prepareStatement(WITHDRAW_MONEY_QUERY);
			statement.setInt(1, amount);
			statement.setInt(2, customerId);

			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (InvalidAmountException e1) {
			System.out.println(e1.getMessage());
		}
		if (res == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean transferMoney(Customer customer) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Receiver Customer ID : ");
		int customerId = sc.nextInt();
		System.out.println("Please enter Sender Customer ID : ");
		int customerId2 = sc.nextInt();
		System.out.println("Enter your amount to transfer : ");
		int amount = sc.nextInt();
		int res = 0;

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DEPOSIT_MONEY_QUERY);
			statement.setInt(1, amount);
			statement.setInt(2, customerId);

			statement.close();

			statement = connection.prepareStatement(WITHDRAW_MONEY_QUERY);
			statement.setInt(1, amount);
			statement.setInt(2, customerId2);

			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (res == 0)
			return false;
		else
			return true;
	}

	@SuppressWarnings("null")
	@Override
	public boolean viewBalance(int customerId) {
		ResultSet res = null;

		try {
			PreparedStatement statement = connection.prepareStatement(VIEW_BALANCE_QUERY);
			statement.setInt(1, customerId);
			ResultSet res1 = statement.executeQuery();
			if (res1.next()) {
				int currentBalance = res1.getInt("currentBalance");
				System.out.println("The balance in your account is:" + currentBalance);
			} else
				System.out.println("The account is Wrong ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		if (res == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean isCustomerExist(int customerId) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			PreparedStatement stat = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
			stat.setInt(1, customerId);
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

}
