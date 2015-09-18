package by.academy.service.interf;


import java.util.Date;
import java.util.List;

import by.academy.dao.CustomEventDao;
import by.academy.dao.DaoException;
import by.academy.dto.EventDto;
import by.academy.pojos.CriminalEvent;
import by.academy.service.exeption.ServiceException;

public interface EventService {
	
	void add(EventDto eventDto ) throws  ServiceException;
	
	void delete(Integer eventId) throws ServiceException;
	
	CriminalEvent getEventByID(Integer eventId) throws ServiceException;
	
	List<CriminalEvent> getEventsByUserId(int userId) throws  ServiceException;
	
	List<CriminalEvent> getEventsByDate(Date date) throws  ServiceException;
	
	List<CriminalEvent> getEvents() throws ServiceException;
	
	List<CriminalEvent> getEventsByCriminalId(int criminalId) throws  ServiceException;
	
	void setEventDao(CustomEventDao eventDao);
}
