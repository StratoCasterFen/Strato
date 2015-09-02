package by.academy.dao;

import java.util.Date;
import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;

public interface CustomEventDao extends GenericHDao<CriminalEvent>{
	
	List<CriminalEvent> getEventsByDate(Date date) throws DaoException;

	List<CriminalEvent> getEventsByCriminal(Criminal criminal) throws DaoException;

	List<CriminalEvent> getEventsByType(EventType eventType) throws DaoException;

	List<CriminalEvent> getEventsByUser(User user) throws DaoException;

}
