package by.academy.service.interf;

import java.util.List;

import by.academy.domain.Criminal;
import by.academy.mydao.DaoException;

public interface CriminalService {
	
	List<Criminal> getCriminals() throws DaoException;
	
	void addCriminal(Criminal criminal) throws DaoException;
	
	void updateCriminal(Criminal criminal) throws DaoException;
	
	void deleteCriminal(int criminalId) throws DaoException;
	
}
