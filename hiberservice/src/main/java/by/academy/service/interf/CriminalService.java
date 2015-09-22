package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.dao.CustomCriminalDao;
import by.academy.dto.CriminalDto;
import by.academy.service.exeption.ServiceException;

public interface CriminalService {
	
	List<Criminal> getCriminals() throws  ServiceException;
	
	Criminal getCriminalById(Integer criminalId) throws ServiceException;

	void setCriminalDao(CustomCriminalDao criminalDao);

	void addCriminal(CriminalDto criminalDto) throws ServiceException;

	void deleteById(Integer criminalId) throws ServiceException;

	void updateCriminal(CriminalDto criminalDto) throws ServiceException;
}
