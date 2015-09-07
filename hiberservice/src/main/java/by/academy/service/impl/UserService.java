package by.academy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.academy.dao.CustomUserDao;
import by.academy.dao.DaoException;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.ModelUser;
import by.academy.service.ServiceException;
import by.academy.service.interf.IUserService;

public class UserService implements IUserService {
	static Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Override
	public User authorization(String userName, String password)
			throws ServiceException, DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(ModelUser user) throws ServiceException, DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Role> getRolesByUserId(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserDAO(CustomUserDao userDao) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() throws DaoException, ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String userName) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
