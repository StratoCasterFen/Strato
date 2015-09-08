package by.academy.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import by.academy.dao.CustomEventDao;
import by.academy.dao.CustomUserDao;
import by.academy.dao.DaoException;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.ModelUser;
import by.academy.service.ServiceException;
import by.academy.service.interf.IUserService;
import by.academy.service.utils.ConnectionManager;
import by.academy.service.utils.MD5;

public class UserService implements IUserService {
	static Logger logger = Logger.getLogger(UserService.class.getName());
	final static String SALT="Fender";
	
	private CustomUserDao userDao;
	private EntityManager em;
	
	public UserService() throws DaoException{
		this.em=ConnectionManager.getEntityManager();
	}
	
	@Override
	public User authorization(String userName, String password) throws ServiceException{
		User user = new User();
		user.setUserName(userName);
		
	    String md5Password;
	    MD5 md5 = new MD5();
	    md5Password = md5.getHash(md5.getHash(password) + md5.getHash(SALT));
		user.setPassword(md5Password);
	
		User existingUser = null;
		
		try {
			existingUser = userDao.getUserByNameAndPassword(user);
		} catch (DaoException e) {
			logger.error("Can't get user by Name & password");
			throw new ServiceException("Can't get user by Name & password",e);
		} catch (NullPointerException e){
			logger.error("UserDao don't set",e);
			throw new ServiceException("UserDao don't set",e);
		}
		
		if (existingUser == null) {
			logger.error("Didn't find user");
			throw new ServiceException("Didn't find user");
		}
		logger.info("Authoruthation successfully!");
		return existingUser;
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
	public List<User> getAllUsers() throws DaoException, ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String userName) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(CustomUserDao userDao) {
		logger.info("setUserDao");
		this.userDao = userDao;
		this.userDao.setEntityManager(em);
	}

}
