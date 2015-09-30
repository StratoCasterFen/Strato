package by.academy.dao.iRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.pojos.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	
	@Query("select u from User u where u.userName = :name")
	User getUserByName(@Param("name") String userName); 
	
	@Query("Select r FROM Role r inner join r.users u WHERE u.id=:userId") 
	List getRolesForUser(@Param("userId") Integer userId);
	
}
