package by.academy.domain;

import by.academy.mydao.Identified;

public class Role implements Identified<Integer>{
	private Integer id=null;
	private String  roleName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [Id=" + id + ", roleName=" + roleName + "]";
	}
	
}
