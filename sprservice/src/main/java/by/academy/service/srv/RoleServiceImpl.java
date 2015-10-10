package by.academy.service.srv;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.RoleRepo;
import by.academy.dto.CriminalDto;
import by.academy.dto.RoleDto;
import by.academy.dto.UserRoleDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.Role;
import by.academy.pojos.User;

@Service
public class RoleServiceImpl implements RoleService {
	static Logger logger= Logger.getLogger(RoleServiceImpl.class.getName());
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static class ConvertDto {

		public static List fromRoleList(List<Role> roles) {
			logger.info("***Convert rolesList to rolesDtoList***");
			List<RoleDto> rolesDto = new ArrayList<>();
			for (Role role : roles) {
				rolesDto.add(fromRole(role));
			}
			return rolesDto;
		}

		private static RoleDto fromRole(Role role) {
			if (role == null) {
				logger.debug("Role is null");
				return null;
			}
			return new RoleDto(role.getId(), role.getRoleName());
		}
	}
	
	@Override
	public Role getRolebyId(Integer roleId) {
		logger.info("************getRolebyId***********");
		return roleRepo.findOne(roleId);
	}

	@Override
	public Role addRole(Role role) {
		logger.info("************addRole***********");
		Role savedRole=roleRepo.saveAndFlush(role);
		return savedRole;
	}

	@Override
	public void deleteById(Integer roleId) {
		logger.info("************deleteById***********");
		roleRepo.delete(roleId);;
	}

	@Override
	public void update(Role role) {
		logger.info("************update***********");
		roleRepo.saveAndFlush(role);
	}

	@Override
	public List<RoleDto> getRoles() {
		logger.info("************getRoles***********");
		List roles = roleRepo.findAll();
		List rolesDto=ConvertDto.fromRoleList(roles);
		return rolesDto;
	}

}
