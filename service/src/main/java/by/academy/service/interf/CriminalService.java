package by.academy.service.interf;

import java.util.List;

import by.academy.domain.Criminal;
import by.academy.mydao.DaoException;
import by.academy.service.exception.ServiceException;

public interface CriminalService {
	
	List<Criminal> getCriminals() throws DaoException;
	

	
	void addCriminal(Criminal criminal) throws DaoException, ServiceException;
	
	void updateCriminal(Criminal criminal) throws DaoException, ServiceException;
	
	void deleteById(int criminalId) throws DaoException, ServiceException;

	Criminal getCriminalById(Integer criminalId) throws DaoException,ServiceException;
	
}
