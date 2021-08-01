package com.revature.training.project.model;

import java.io.Serializable;

public class User implements Serializable  {
	
	private int userid;
	private String userName;
	private String userPassword;
	
	public User(){
		
	}

	public User(int userid, String userName, String userPassword) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}
