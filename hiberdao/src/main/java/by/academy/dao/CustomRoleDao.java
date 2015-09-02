package by.academy.dao;

import java.util.List;

import by.academy.pojos.Role;
import by.academy.pojos.User;

public interface CustomRoleDao extends GenericHDao<Role>{
	
	Role getRoleByName(String name) throws DaoException;
	
	List<User> getUsersByRole();

}
