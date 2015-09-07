package by.academy.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import by.academy.dao.AbstractHDao;
import by.academy.dao.CustomEventDao;
import by.academy.dao.DaoException;
import by.academy.dao.GenericHDao;
import by.academy.pojos.CriminalEvent;
import by.academy.service.ServiceException;
import by.academy.service.interf.IEventService;

public class EventService implements IEventService {
	static Logger logger = Logger.getLogger(EventService.class.getName());

	private CustomEventDao eventDao;
	
	@Override
	public void add(CriminalEvent event) throws DaoException, ServiceException {
		logger.info("add");
		try {
			
			eventDao.persist(event);
		} catch (DaoException e) {
			logger.error("could not add event");
			throw new ServiceException("could not add event");
		}
	}

	@Override
	public void delete(Integer eventId) throws ServiceException {
		logger.info("delete event.");

		try {
			CriminalEvent event = getEventByID(eventId);
			getEventDao().delete(event);
		} catch (DaoException e) {
			logger.error("can not delete event " + eventId + ". " + e);
			throw new ServiceException("can not delete event. " + e);
		}
	}

	@Override
	public CriminalEvent getEventByID(Integer eventId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalEvent> getEventsByUserId(int userId)
			throws DaoException, ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) throws DaoException, ServiceException {
		logger.info("getEventsByDate");
		try {
			logger.info("run method getEventsByDate");
			return eventDao.getEventsByDate(date);
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}
	}

	@Override
	public List<CriminalEvent> getEvents() throws ServiceException,
			DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalEvent> getEventsByCriminalId(int criminalId)
			throws DaoException, ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  CustomEventDao getEventDao() throws ServiceException {
		logger.info("run method getEventDao");
		if (eventDao == null) {
			logger.error("error. need eventDao in EventService");
			throw new ServiceException("need eventDao in EventService.");
		}
		return eventDao;
	}

	public void setEventDao(CustomEventDao eventDao) {
		logger.info("setEventDao");
		this.eventDao = eventDao;
	}

}
