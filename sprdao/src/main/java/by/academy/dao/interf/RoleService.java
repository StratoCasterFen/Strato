package by.academy.dao.interf;

import java.util.List;

import by.academy.pojos.Role;

public interface RoleService {
	Role getRolebyId(Integer roleId);
	Role addRole(Role role);
	void deleteById(Integer roleId);
	void update(Role role);
	List<Role> getRoles();
}
