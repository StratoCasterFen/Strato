package by.academy.domain;

import by.academy.mydao.GenericDao;

public class User {
	private Integer UserId=null;
	private String UserName;
	private String Password;
	
	public User(Integer userId, String userName, String password) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
	}
	
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + "]";
	}
		
}
