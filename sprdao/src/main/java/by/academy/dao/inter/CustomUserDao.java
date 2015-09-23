package by.academy.dao.inter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.academy.dao.GenericHDao;
import by.academy.pojos.User;

public interface CustomUserDao extends CrudRepository<User, Integer> {
	
	//User getUserByNameAndPassword(User user) throws DaoException;
	
	User getUserByName(String userName); 
	
	List getRolesForUser(User user);
	
}
