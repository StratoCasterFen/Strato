package by.academy.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import by.academy.dao.inter.CustomUserDao;
import by.academy.hbutil.ReadProperty;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public class UserDaoImpl  implements CustomUserDao {
	static Logger logger= Logger.getLogger(UserDaoImpl.class.getName());
	
	public UserDaoImpl() {
	}

	public User getUserByNameAndPassword(User user)  {
		logger.info("+getUserByNameAndPassword");
		return user;
		
	}

	public User getUserByName(String userName)   {
		logger.info("+getUserByName");
		return null;
		
	}

	@Override
	public List getRolesForUser(User user) {
		logger.info("+getRolesForUser");
		return null;
		
	}

}
