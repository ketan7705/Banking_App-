package com.revature.training.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.training.project.model.User;
import com.revature.training.project.util.DBConnection;

public class UserDAOImple implements UserDAO{
	Connection connection = DBConnection.getDBConnection();
	@Override
	public boolean validateUser(User user) {
		
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select * from customers where customerName = ? and customerPassword = ?");
			statement.setString(1,user.getUserName());
			statement.setString(2,user.getUserName());

			ResultSet res = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
