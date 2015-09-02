package by.academy.dao;

import java.util.List;

import by.academy.pojos.Role;
import by.academy.pojos.User;

public interface CustomUserDao extends GenericHDao<User> {
	
	User getUserByNameAndPassword(User user) throws DaoException;
	
	User getUserByName(String userName) throws DaoException;
	
	List getRolesForUser(User user);
	
}
