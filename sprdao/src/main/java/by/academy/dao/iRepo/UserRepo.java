package by.academy.dao.iRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.pojos.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	//User getUserByNameAndPassword(User user) throws DaoException;
	
	@Query("select u from User u where u.userName = :name")
	User getUserByName(@Param("name") String userName); 
	
	List getRolesForUser(User user);
	
}
