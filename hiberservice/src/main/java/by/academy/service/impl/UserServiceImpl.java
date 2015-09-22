package by.academy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import by.academy.dao.CustomUserDao;
import by.academy.dao.RoleDao;
import by.academy.dao.UserDao;
import by.academy.dao.exception.DaoException;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.dto.UserRoleDto;
import by.academy.hbutil.ConvertDto;
import by.academy.service.exeption.ServiceException;
import by.academy.service.interf.UserService;
import by.academy.service.utils.ConnectionManager;
import by.academy.service.utils.MD5;

public class UserServiceImpl implements UserService {
	static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	final static String SALT="Fender";
	
	private CustomUserDao userDao;
	private EntityManager em;
	private RoleDao roleDao;
	
	public UserServiceImpl() throws ServiceException{
		try {
			this.em=ConnectionManager.getEntityManager();
		} catch (DaoException e) {
			logger.error("dont get EntityManager");
			throw new ServiceException("dont get EntityManager",e);
		}
		setUserDao(new UserDao());
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
	public void addUser(UserRoleDto userRoleDto) throws ServiceException {
		logger.info("addUser");
		try {
			if (userDao.getUserByName(userRoleDto.getUserName())!=null){
				logger.error("user with that name allready exist");
				throw new ServiceException("user with that name allready exist");
			}
		} catch (DaoException e1) {
			throw new ServiceException("error0", e1);
		}
		
	    String md5Password;
	    MD5 md5 = new MD5();
	    md5Password = md5.getHash(md5.getHash(userRoleDto.getUserName()) + md5.getHash(SALT));
	    userRoleDto.setPassword(md5Password);	    
		
	    EntityTransaction tx = em.getTransaction();
		User user=ConvertDto.toUser(userRoleDto);
		setRoleDao();
		try {
			Role role=roleDao.getByPK(userRoleDto.getIdRole());
			logger.info("role : " +role);
			Set<Role> roles = new HashSet();
			roles.add(role);
			user.setRoles(roles);
		    tx.begin(); 
			userDao.persist(user);
			tx.commit();
		} catch (DaoException e) {
			logger.error("could not add user");
			tx.rollback();
			throw new ServiceException("could not add user");
		}finally{
			ConnectionManager.Close();
		}	

	}

	@Override
	public List<Role> getRolesByUserId(int userId) throws ServiceException {
		
		try {
			User user = userDao.getByPK(userId);
			logger.info("user : " + user);
			return userDao.getRolesForUser(user);
		} catch (DaoException e) {
			logger.error("can not get roles! " + e);
			throw new ServiceException("can not get roles! " + e);
		}finally{
			ConnectionManager.Close();
		}	
	}

	@Override
	public List<User> getAllUsers() throws  ServiceException {
		logger.info("getAllUsers");
		try {
			logger.info("run method getEvents");
			return userDao.getAll();
		} catch (DaoException e) {
			logger.error("need userDao in UserService.");
			throw new ServiceException("need userDao in UserService.");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public User getUserByName(String userName) throws ServiceException {
		logger.info("getUserByName");
		try {
			User user = userDao.getUserByName(userName);
			return user;
		} catch (DaoException e) {
			logger.error("can not get user! " + e);
			throw new ServiceException("can not get user! " + e);
		}
	}

	public CustomUserDao getUserDao() {
		return userDao;
	}
	public void setRoleDao() {
		logger.info("setRoleDao");
		this.roleDao = new RoleDao();
		this.roleDao.setEntityManager(em);
	}
	public void setUserDao(CustomUserDao userDao) {
		logger.info("setUserDao");
		this.userDao = userDao;
		this.userDao.setEntityManager(em);
	}

	@Override
	public User getUserById(Integer userId) throws ServiceException {
		logger.info("getUserById");
		try {
			User user = userDao.getByPK(userId);
			return user;
		} catch (DaoException e) {
			logger.error("can not get user! " + e);
			throw new ServiceException("can not get user! " + e);
		}
	}

}
