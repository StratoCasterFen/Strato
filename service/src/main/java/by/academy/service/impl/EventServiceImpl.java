package by.academy.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.EventService;

public class EventServiceImpl implements EventService {

	static Logger logger = Logger.getLogger(EventServiceImpl.class.getName());
	private GenericDao<CriminalEvent, Integer> eventDao;
	private MySqlCriminalEventDao criminalEvent = (MySqlCriminalEventDao) eventDao;

	@Override
	public void add(CriminalEvent event) throws DaoException, ServiceException {
		logger.info("+add event.");
		try {
			eventDao.persist(event);
		} catch (DaoException e) {
			logger.error("could not add event");
			throw new ServiceException("Login or password is incorrect.");
		} finally {

		}
		logger.info("-add event.");
	}

	@Override
	public void deleteByID(Integer eventId) throws ServiceException {
		logger.info("+delete event.");

		try {
			CriminalEvent event = getEventByID(eventId);
			getEventDao().delete(event);
		} catch (DaoException e) {
			logger.error("can not delete event " + eventId + ". " + e);
			throw new ServiceException("can not delete event. " + e);
		}
		logger.info("-delete event.");
	}

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) throws DaoException,
			ServiceException {
		logger.info("+getEventsByDate");

		try {
			logger.info("run method getEventsByDate");
			return criminalEvent.getByDate(date);
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}
	}

	@Override
	public List<CriminalEvent> getEvents() throws DaoException {
		logger.info("run method getEvents");
		return criminalEvent.getAll();
	}

	@Override
	public List<CriminalEvent> getEventsByUserId(int userId)
			throws DaoException, ServiceException {
		logger.info("+getEventsByUserId");

		try {
			logger.info("run method getEvents()");
			return criminalEvent.getByUserId(userId);
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}
	}

	@Override
	public List<CriminalEvent> getEventsByCriminalId(int criminalId)
			throws DaoException, ServiceException {
		logger.info("+getEventsByCriminalId");

		try {
			logger.info("-getEventsByCriminalId");
			return criminalEvent.getByCriminalId(criminalId);
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}
	}

	public GenericDao<CriminalEvent, Integer> getEventDao()
			throws ServiceException {
		logger.info("run method getEventDao");
		if (eventDao == null) {
			logger.error("error. need eventDao in EventService");
			throw new ServiceException("need eventDao in EventService.");
		}
		return eventDao;
	}

	public void setEventDao(GenericDao<CriminalEvent, Integer> eventDao) {
		logger.info("run method setEventDao");
		this.eventDao = eventDao;
	}

	@Override
	public CriminalEvent getEventByID(Integer eventId) throws ServiceException {
		logger.info("+getEvent");
		CriminalEvent event = null;
		try {
			event = getEventDao().getByPK(eventId);
		} catch (DaoException e) {
			logger.error("can not get event by Id");
			throw new ServiceException("can not get event by Id. ", e);
		}
		logger.debug("-getEvent. Return event: " + event);
		return event;
	}

}
