package by.academy.dao;

import java.util.List;

import by.academy.dao.exception.DaoException;
import by.academy.pojos.User;

public interface CustomUserDao extends GenericHDao<User> {
	
	User getUserByNameAndPassword(User user) throws DaoException;
	
	User getUserByName(String userName) throws DaoException;
	
	List getRolesForUser(User user) throws DaoException;
	
}
