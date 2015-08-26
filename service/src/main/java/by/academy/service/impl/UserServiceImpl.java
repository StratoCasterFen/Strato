package by.academy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.UserService;

public class UserServiceImpl implements UserService {
	static Logger logger= Logger.getLogger(UserServiceImpl.class.getName());
	private GenericDao<User, Integer> userDao;
	private MySqlUserDao mUser = (MySqlUserDao) userDao;
	
	final static String SALT="Fender";
	
	@Override
	public User authorization(String userName, String password) throws ServiceException {

		User user = new User();
		user.setUserName(userName);
		
        String md5Password;
        MD5 md5 = new MD5();
        md5Password = md5.getHash(md5.getHash(password) + md5.getHash(SALT));
		user.setPassword(md5Password);

		User existingUser = null;
		
		try {
			existingUser = mUser.getUserByNameAndPassword(user);
		} catch (DaoException e) {
			logger.error("Can't get user by Name & password");
			throw new ServiceException("Can't get user by Name & password");
		}
		
		if (existingUser == null) {
			logger.error("Didn't find user");
			throw new ServiceException("Didn't find user");
		}
		logger.info("Authoruthation successfully!");
		return existingUser;
	}

	@Override
	public void addUser(ModelUser modelUser) throws ServiceException, DaoException {
		logger.info("+addUser");
		
		User existingUser = mUser.getUserByName(modelUser.getUserName());
		
		if (existingUser == null) {
			String password = modelUser.getPassword(); 
			String md5Password;
			MD5 md5 = new MD5();
			md5Password = md5.getHash(md5.getHash(password) + md5.getHash(SALT));
			
			User newUser=new User();
			newUser.setUserName(modelUser.getUserName());
			newUser.setPassword(md5Password);

			mUser.persist(newUser);
			logger.info("-addUser successfully");
		} else {
			logger.error("user exist");
			throw new ServiceException("User name exist.");
		}
	}

	@Override
	public List<Role> getRolesByUserId(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String userName) throws ServiceException {
		logger.info("+getUserByName");
		try {
			return mUser.getUserByName(userName);
		} catch (DaoException e) {
			logger.error("cant perform user");
			throw new ServiceException("cant perform user");
		}
	}

	@Override
	public void setUserDAO(GenericDao<User, Integer> userDao) {
		logger.info("Set userDao.");
		this.userDao = userDao;
	}

	public GenericDao<User, Integer> getUserDao() throws ServiceException {
		logger.info("run method getUserDao");
		if (userDao == null) {
			logger.error("error. need userDao in UserService");
			throw new ServiceException("need userDao in UserService");
		}
		return userDao;
	}

	@Override
	public List<User> getAllUsers() throws DaoException, ServiceException {
		logger.info("Getting all users");
		List<User> users;
		try {
			users = getUserDao().getAll();
			logger.info("Returning all users");
			return users;
		} catch (DaoException e) {
			logger.error("Can not get user list. ");
			throw new ServiceException("Can not get user list. " + e);
		}
	}

}
