package by.academy.service.srv;

import java.util.List;

import by.academy.dto.RoleDto;
import by.academy.pojos.Role;

public interface RoleService {
	Role getRolebyId(Integer roleId);
	Role addRole(Role role);
	void deleteById(Integer roleId);
	void update(Role role);
	List<RoleDto> getRoles();
}
