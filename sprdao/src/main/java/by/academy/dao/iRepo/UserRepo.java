package by.academy.dao.iRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import by.academy.pojos.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	//User getUserByNameAndPassword(User user) throws DaoException;
	
	User getUserByName(String userName); 
	
	List getRolesForUser(User user);
	
}
