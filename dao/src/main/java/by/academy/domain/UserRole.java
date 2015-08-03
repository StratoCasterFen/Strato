package by.academy.domain;

import by.academy.mydao.Identified;

public class UserRole implements Identified<Integer>{
	private Integer id=null;
	private User User;
	private Role Role;
		
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}

	public Role getRole() {
		return Role;
	}
	public void setRole(Role role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", User=" + User.getUserName() + ", Role=" + Role.getRoleName() + "]";
	}

}
