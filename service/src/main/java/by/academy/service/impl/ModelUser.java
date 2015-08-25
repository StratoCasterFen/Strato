package by.academy.service.impl;

public class ModelUser {
	private String userName;
	private String password;

	public ModelUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ModelUser [userName=" + userName + ", password=" + password	+ "]";
	}
	

}
