package by.academy.service.srv;

import java.util.List;
import java.util.Set;

import by.academy.dto.UserRoleDto;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public interface UserService {
//	User authorization(String userName, String password);

	List getRolesByUserId(Integer userId);

	User getUserById(Integer userId);

	List<User> getAllUsers();

	User getUserByName(String userName);

	//User addUser(User user);

	void deleteById(Integer userId);
	
	void update(User user);

	User addUser(UserRoleDto userDto);
}
