package by.academy.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.UserRepo;

import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.interf.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	static Logger logger= Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserRepo userRepo;
	
//	@Override
//	public User authorization(String userName, String password) {
//		logger.info("+authorization");
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List getRolesByUserId(Integer userId) {
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
	@Transactional
	public User addUser(User user) {
		logger.info("**************addUser************");
		User savedUser=userRepo.saveAndFlush(user);
		return savedUser;		
	}

	@Override
	@Transactional
	public void deleteById(Integer userId) {
		logger.info("**************deleteById***********");
		userRepo.delete(userId);		
	}

	@Override
	@Transactional
	public void update(User user) {
		logger.info("****************update***************");
		userRepo.saveAndFlush(user);	
	}

}