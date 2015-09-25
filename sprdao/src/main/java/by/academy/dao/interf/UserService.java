package by.academy.dao.interf;

import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public interface UserService {
	User authorization(String userName, String password);

	List<Role> getRolesByUserId(int userId);

	User getUserById(Integer userId);

	List<User> getAllUsers();

	User getUserByName(String userName);

	User addUser(User user);

	void deleteById(Integer userId);
	
	void update(User user);
}
