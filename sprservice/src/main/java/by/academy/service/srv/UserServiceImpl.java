package by.academy.service.srv;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.RoleRepo;
import by.academy.dao.iRepo.UserRepo;
import by.academy.dto.UserRoleDto;
import by.academy.pojos.Role;
import by.academy.pojos.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	static Logger logger= Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private Md5PasswordEncoder passwordEncoder;
	
	public static class ConvertDto {
		public static User toUser(UserRoleDto userRoleDto) {
			logger.info("***Convert UserDto to User***");
			if (userRoleDto == null) {
				return null;
			}
			User user = new User();
			user.setUserName(userRoleDto.getUserName());
			user.setPassword(userRoleDto.getPassword());
			return user;
		}
	}
	
	@Override
	public List<Role> getRolesByUserId(Integer userId) {
		logger.info("********getRolesByUserId*********");
		return userRepo.getRolesForUser(userId);
	}

	@Override
	public User getUserById(Integer userId) {
		logger.info("************getUserById***********");
		return userRepo.findOne(userId);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("*************getAllUsers***********");
		return userRepo.findAll();
	}

	@Override
	public User getUserByName(String userName) {
		logger.info("*************getUserByName*************");
		return userRepo.getUserByName(userName);
	}

	@Override
	public User addUser(UserRoleDto userDto) {
		logger.info("**************addUser************");
		String md5pas=md5Password(userDto.getPassword());
		userDto.setPassword(md5pas);
		User user=ConvertDto.toUser(userDto);
		Role role=roleRepo.findOne(userDto.getIdRole());
		Set<Role> roles = new HashSet();
		roles.add(role);
		user.setRoles(roles);
		User savedUser=userRepo.saveAndFlush(user);
		return savedUser;		
	}

	@Override
	public void deleteById(Integer userId) {
		logger.info("**************deleteById***********");
		userRepo.delete(userId);		
	}

	@Override
	public void update(User user) {
		logger.info("****************update***************");
		userRepo.saveAndFlush(user);	
	}

	private String md5Password(String password) {
		return passwordEncoder.encodePassword(password, null);
	}

}
