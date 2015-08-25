package by.academy.service.interf;

import java.util.List;

import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.ModelUser;

public interface UserService {

	User authorization(String userName, String password) throws ServiceException, DaoException;
	
	void addUser(ModelUser user) throws ServiceException, DaoException;
	
	List<Role> getRolesByUserId(int userId) throws ServiceException;

	void setUserDAO(GenericDao<User, Integer> userDao);
	
	List<User> getAllUsers() throws  DaoException, ServiceException;

	User getUserByName(String userName) throws ServiceException;
}
