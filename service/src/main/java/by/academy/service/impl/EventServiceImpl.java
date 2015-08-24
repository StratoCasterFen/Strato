package by.academy.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.EventService;

public class EventServiceImpl implements EventService {
	
	static Logger logger= Logger.getLogger(EventServiceImpl.class.getName());
	private GenericDao<CriminalEvent, Integer> eventDao;
	
	@Override
	public void add(CriminalEvent event) throws DaoException {
		logger.info("+add event.");
		try {
			eventDao.persist(event);
		} catch (DaoException e) {
			logger.error("could not add event");
			e.printStackTrace();
		} finally {

		}
		logger.info("-add event.");
	}

	@Override
	public void deleteByID(Integer eventId) throws ServiceException  {
		logger.info("+delete event.");

		try {
			CriminalEvent event=getEventByID(eventId);
			getEventDao().delete(event);
		} catch (DaoException e) {
			logger.error("can not delete event " + eventId + ". "+ e);
			e.printStackTrace();
		}
		logger.info("-delete event."); 
	}

	@Override
	public List<CriminalEvent> getEventsByUserId(int userId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalEvent> getEvents() throws DaoException  {
		
	    Connection connection =  new MySqlDaoFactory().getConnection();
	    MySqlCriminalEventDao criminalEvent= new MySqlCriminalEventDao(connection);
	    
		logger.info("run method getEvents()");
		return criminalEvent.getAll();
	}

	@Override
	public List<CriminalEvent> getEventsByCriminalId(int criminalId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public GenericDao<CriminalEvent, Integer> getEventDao() throws ServiceException {
		if (eventDao == null) {
			logger.error("error. need eventDao in EventService");
			throw new ServiceException("need eventDao in EventService.");
		}
		return eventDao;
	}

	public void setEventDao(GenericDao<CriminalEvent, Integer> eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public CriminalEvent getEventByID(Integer eventId) throws ServiceException {
		logger.info("+getEvent");
		CriminalEvent event = null;
		try {
			event = getEventDao().getByPK(eventId);
		} catch (DaoException e) {
			logger.error("can not get event by pk"+e);
			throw new ServiceException("can not get event by pk", e);
		}
		logger.info("-getEvent. Return event: " + event);
		return event;
	}



}
