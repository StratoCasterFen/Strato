package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.dao.DaoException;
import by.academy.service.ServiceException;

public interface ICriminalService {
	
	List<Criminal> getCriminals() throws DaoException;

	void addCriminal(Criminal criminal) throws DaoException, ServiceException;
	
	void updateCriminal(Criminal criminal) throws DaoException, ServiceException;
	
	void deleteById(int criminalId) throws DaoException, ServiceException;

	Criminal getCriminalById(Integer criminalId) throws DaoException,ServiceException;
}
