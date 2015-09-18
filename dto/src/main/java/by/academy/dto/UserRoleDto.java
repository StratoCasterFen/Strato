package by.academy.dto;

import java.util.Set;

public class UserRoleDto {
	private Integer idUser;
	private String userName;
//	private Integer idRole;
	private Set<RoleDto> rolesDto;


	public UserRoleDto(Integer idUser, String userName, Set<RoleDto> rolesDto) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.rolesDto = rolesDto;
	}

	public Set<RoleDto> getRolesDto() {
		return rolesDto;
	}

	public void setRolesDto(Set<RoleDto> rolesDto) {
		this.rolesDto = rolesDto;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public Integer getIdRole() {
//		return idRole;
//	}
//
//	public void setIdRole(Integer idRole) {
//		this.idRole = idRole;
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((rolesDto == null) ? 0 : rolesDto.hashCode());
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
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (rolesDto == null) {
			if (other.rolesDto != null)
				return false;
		} else if (!rolesDto.equals(other.rolesDto))
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
		return "UserRoleDto [idUser=" + idUser + ", userName=" + userName + ", rolesDto=" + rolesDto + "]";
	}
	
	

}
