package by.academy.domain;

import by.academy.mydao.Identified;

public class UserRole implements Identified<Integer>{
	private Integer id=null;
	private Integer userId;
	private Integer roleId;
		
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", Userid=" + userId + ", Roleid=" + roleId + "]";
	}

}
