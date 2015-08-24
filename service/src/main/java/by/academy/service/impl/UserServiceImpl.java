package by.academy.service.impl;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.domain.CriminalEvent;
import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.UserService;

public class UserServiceImpl implements UserService {
	private MySqlUserDao daoUser;
	final static String SALT="Fender";
	
	static Logger logger= Logger.getLogger(UserServiceImpl.class.getName());
	
	@Override
	public User authorization(String userName, String password) throws ServiceException, DaoException {

		User user = new User();
		user.setUserName(userName);
		
        String md5Password;
        MD5 md5 = new MD5();
        md5Password = md5.getHash(md5.getHash(password) + md5.getHash(SALT));
		user.setPassword(md5Password);
		
		MySqlDaoFactory factory = new MySqlDaoFactory();
		MySqlUserDao daoUser= new MySqlUserDao(factory.getConnection());
		User existingUser = null;
		
		existingUser = daoUser.getUserByNameAndPassword(user);
		
		if (existingUser == null) {
			logger.error("Didn't find user");
			throw new ServiceException("Login or password is incorrect.");
		}
		logger.info("End authoruthation.");
		return existingUser;
	}

	@Override
	public void addUser(ModelUser mUser) throws ServiceException, DaoException {
		MySqlDaoFactory factory = new MySqlDaoFactory();
		MySqlUserDao daoUser= new MySqlUserDao(factory.getConnection());
		
		String userName = mUser.getUserName();
		
		User existingUser = daoUser.getUserByName(userName);
		
		if (existingUser == null) {
			logger.info("+add user");
			GenericDao dao = factory.getDao(factory.getConnection(), User.class);
			
			String password = mUser.getPassword(); 
			String md5Password;
			MD5 md5 = new MD5();
			md5Password = md5.getHash(md5.getHash(password) + md5.getHash(SALT));
			
			User newUser=new User();
			newUser.setUserName(userName);
			newUser.setPassword(md5Password);

			dao.persist(newUser);
			logger.info("-add user");
		} else {
			logger.error("user exist");
			throw new ServiceException("User name exist.");
		}
	}

	@Override
	public List<Role> getRoleByUserId(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public User getUserByName(String userName) throws ServiceException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void setUserDAO(MySqlUserDao daoUser) {
		logger.info("Set daoUser.");
		this.daoUser = daoUser;
	}

	@Override
	public List<User> getAllUsers() throws DaoException{
		logger.info("Getting all users");
		List<User> users;
		MySqlDaoFactory factory = new MySqlDaoFactory();
		MySqlUserDao daoUser = new MySqlUserDao(factory.getConnection());
		try {
			users = daoUser.getAll();
			logger.info("Returning all users");
			return users;
		} catch (DaoException e) {
			logger.error("e");
			e.printStackTrace();
		}
		return null;
		
	}
	
}
