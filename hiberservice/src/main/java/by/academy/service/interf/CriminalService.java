package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.dao.CustomCriminalDao;
import by.academy.service.exeption.ServiceException;

public interface CriminalService {
	
	List<Criminal> getCriminals() throws  ServiceException;

	void addCriminal(Criminal criminal) throws  ServiceException;
	
	void updateCriminal(Criminal criminal) throws  ServiceException;
	
	void deleteById(int criminalId) throws  ServiceException;

	Criminal getCriminalById(Integer criminalId) throws ServiceException;

	void setCriminalDao(CustomCriminalDao criminalDao);
}
