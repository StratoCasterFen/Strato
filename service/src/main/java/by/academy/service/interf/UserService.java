package by.academy.service.interf;

import java.util.List;
import by.academy.domain.*;
import by.academy.mydao.DaoException;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;

public interface UserService {

	User authorization(String userName, String password) throws ServiceException, DaoException;
	
	void addUser(User user) throws ServiceException, DaoException;
	
	//void addEvent(CriminalEvent event) throws ServiceException;
	
	//void updateEvent(CriminalEvent event) throws ServiceException;
	
	//void deleteEventById(int eventIid) throws ServiceException;
	
	//List<CriminalEvent> getOrdersByUserId(int userId) throws ServiceException;
	
	List<Role> getRoleByUserId(int userId) throws ServiceException;
	
	User getUserByName(String userName) throws ServiceException;

	void setUserDAO(MySqlUserDao daoUser);

	
}
