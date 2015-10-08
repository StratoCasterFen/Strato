package by.academy.service.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.RoleRepo;
import by.academy.pojos.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public Role getRolebyId(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Role> getRoles() {
		return roleRepo.findAll();
	}

}
