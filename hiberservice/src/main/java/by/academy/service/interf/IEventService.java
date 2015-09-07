package by.academy.service.interf;


import java.util.Date;
import java.util.List;

import by.academy.dao.CustomEventDao;
import by.academy.dao.DaoException;
import by.academy.pojos.CriminalEvent;
import by.academy.service.ServiceException;

public interface IEventService {
	
	void add(CriminalEvent event ) throws DaoException, ServiceException;
	
	void delete(Integer eventId) throws ServiceException;
	
	CriminalEvent getEventByID(Integer eventId) throws ServiceException;
	
	List<CriminalEvent> getEventsByUserId(int userId) throws DaoException, ServiceException;
	
	List<CriminalEvent> getEventsByDate(Date date) throws DaoException, ServiceException;
	
	List<CriminalEvent> getEvents() throws ServiceException, DaoException;
	
	List<CriminalEvent> getEventsByCriminalId(int criminalId) throws DaoException, ServiceException;
	
	void setEventDao(CustomEventDao eventDao);
}
