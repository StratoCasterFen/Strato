package by.academy.domain;

import by.academy.mydao.Identified;

public class User implements Identified<Integer>{
	private Integer id=null;
	private String  username;
	private String  password;

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [UserId=" + id + ", UserName=" + username + "]";
	}


		
}
