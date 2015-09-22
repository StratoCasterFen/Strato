package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.exeption.ServiceException;
import by.academy.dto.UserRoleDto;

public interface UserService {
	User authorization(String userName, String password) throws ServiceException;

//	void addUser(UserDto user) throws ServiceException;

	List<Role> getRolesByUserId(int userId) throws ServiceException;

	User getUserById(Integer userId) throws ServiceException;

	List<User> getAllUsers() throws ServiceException;

	User getUserByName(String userName) throws ServiceException;

	void addUser(UserRoleDto userRoleDto) throws ServiceException;
}
