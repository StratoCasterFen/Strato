package by.academy.service.interf;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.DaoException;
import by.academy.service.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface EventService {
	
	int add(CriminalEvent event ) throws DaoException;
	
	void deleteByID(int eventId) throws DaoException;
	
	List<CriminalEvent> getEventsByUserId(int userId) throws DaoException;
	
	List<CriminalEvent> getEventsByDate(Date date) throws DaoException;
	
	List<CriminalEvent> getEvents() throws ServiceException, DaoException;
	
	List<CriminalEvent> getEventsByCriminalId(int criminalId) throws DaoException;
	
	
}
