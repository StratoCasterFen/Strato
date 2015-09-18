package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.dao.DaoException;
import by.academy.service.exeption.ServiceException;
import by.academy.dto.UserDto;

public interface UserService {
	User authorization(String userName, String password) throws ServiceException, DaoException;
	
	void addUser(UserDto user) throws ServiceException, DaoException;
	
	List<Role> getRolesByUserId(int userId) throws ServiceException;

//	void setUserDAO(CustomUserDao userDao);
	
	List<User> getAllUsers() throws  DaoException, ServiceException;

	User getUserByName(String userName) throws ServiceException;
}
