package com.revature.training.project.dao;

import java.util.List;

import com.revature.training.project.model.Customer;
import com.revature.training.project.model.User;

public interface CustomerDAO {
	public boolean createAccount(Customer customer);
	public boolean depositMoney(Customer customer);
	public boolean withdrawMoney(Customer customer);
	public boolean transferMoney(Customer customer);
	public boolean viewBalance(int customerIdToTest);
	public boolean isCustomerExist(int customerId);

}
