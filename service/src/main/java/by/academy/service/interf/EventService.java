package by.academy.service.interf;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.DaoException;
import by.academy.service.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface EventService {
	
	void add(CriminalEvent event ) throws DaoException, ServiceException;
	
	void deleteByID(Integer eventId) throws ServiceException;
	
	CriminalEvent getEventByID(Integer eventId) throws ServiceException;
	
	List<CriminalEvent> getEventsByUserId(int userId) throws DaoException, ServiceException;
	
	List<CriminalEvent> getEventsByDate(Date date) throws DaoException, ServiceException;
	
	List<CriminalEvent> getEvents() throws ServiceException, DaoException;
	
	List<CriminalEvent> getEventsByCriminalId(int criminalId) throws DaoException, ServiceException;
	
	
}
