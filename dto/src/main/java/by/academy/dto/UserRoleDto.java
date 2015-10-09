package by.academy.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class UserRoleDto  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idUser;
	@Size(min=3, max=50, message="name must be between 3 and 50 characters long.")
	private String userName;
	@Size(min=3, max=50, message="name must be between 3 and 50 characters long.")
	private String password;
	private Integer idRole;
	
	public UserRoleDto(){
		
	}
	
	public UserRoleDto(String userName, String password, Integer idRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.idRole = idRole;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleDto other = (UserRoleDto) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRoleDto [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", idRole="
				+ idRole + "]";
	}


	

}
