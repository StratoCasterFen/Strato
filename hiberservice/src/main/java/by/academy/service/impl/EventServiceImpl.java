package by.academy.service.impl;

import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.CustomEventDao;
import by.academy.dao.CustomUserDao;
import by.academy.dao.EventDao;
import by.academy.dao.EventTypeDao;
import by.academy.dao.UserDao;
import by.academy.dao.exception.DaoException;
import by.academy.dto.EventDto;
import by.academy.hbutil.ConvertDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;
import by.academy.service.exeption.ServiceException;
import by.academy.service.interf.EventService;
import by.academy.service.utils.ConnectionManager;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventServiceImpl implements EventService {
	static Logger logger = Logger.getLogger(EventServiceImpl.class.getName());

	private CustomEventDao eventDao;
	private CustomUserDao userDao;
	private CustomCriminalDao criminalDao;
	private EventTypeDao eventTypeDao;
	private EntityManager em;

	
	public EventServiceImpl() throws ServiceException {
		try {
			this.em=ConnectionManager.getEntityManager();
		} catch (DaoException e) {
			logger.error("dont get EntityManager");
			throw new ServiceException("dont get EntityManager",e);
		}
		setEventDao(new EventDao());
	}

	@Override
	public void add(EventDto eventDto) throws  ServiceException {
		logger.info("add");
		EntityTransaction tx = em.getTransaction();
		try {
			CriminalEvent event=ConvertDto.toCriminalEvent(eventDto);

		    setUserDao();
		    User user = userDao.getByPK(eventDto.getUserId());
		    event.setUser(user);
		    logger.info("user : " +user);
		    
		    setCriminalDao();
		    Criminal criminal = criminalDao.getByPK(eventDto.getCriminalId());
		    event.setCriminal(criminal);
		    logger.info("criminal : " +criminal);
		    
		    setEventTypeDao();
		    EventType eventType = eventTypeDao.getByPK(eventDto.getEventTypeId());
		    event.setEventType(eventType);
		    logger.info("eventType : " +eventType);
		    
		    tx.begin(); 
			eventDao.persist(event);
			em.flush();
			tx.commit();
		} catch (DaoException e) {
			logger.error("could not add event");
			tx.rollback();
			throw new ServiceException("could not add event");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public void delete(Integer eventId) throws ServiceException {
		logger.info("delete event.");
		EntityTransaction tx = em.getTransaction();
		try {
			CriminalEvent event = eventDao.getByPK(eventId);
		    tx.begin(); 
			getEventDao().delete(event);
			tx.commit();
		} catch (DaoException e) {
			logger.error("can not delete event " + eventId + ". rollback " + e);
			tx.rollback();
			throw new ServiceException("can not delete event. " + e);		
		}finally{
			ConnectionManager.Close();
		}	
	}

	@Override
	public List<CriminalEvent> getEventsByUserId(int userId) throws ServiceException {
		logger.info("getEventsByUserId");
		setUserDao();

		try {
			User user = userDao.getByPK(userId);
			logger.info("user : " + user);
			return eventDao.getEventsByUser(user);
		} catch (DaoException e) {
			logger.error("can not get events! " + e);
			throw new ServiceException("can not get events! " + e);
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) throws  ServiceException {
		logger.info("getEventsByDate");
		try {
			logger.info("run method getEventsByDate");
			return eventDao.getEventsByDate(date);
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public List<CriminalEvent> getEvents() throws ServiceException 	{
		logger.info("getEvents");
		try {
			logger.info("run method getEvents");
			return eventDao.getAll();
		} catch (DaoException e) {
			logger.error("need eventDao in EventService.");
			throw new ServiceException("need eventDao in EventService.");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public List<CriminalEvent> getEventsByCriminalId(int criminalId) throws  ServiceException {
		logger.info("getEventsByCriminalId");
		setCriminalDao();
		Criminal criminal;
		try {
			criminal = criminalDao.getByPK(criminalId);
			return eventDao.getEventsByCriminal(criminal);
		} catch (DaoException e) {
			logger.error("cant get event list.");
			throw new ServiceException("cant get event list", e);
		}finally{
			ConnectionManager.Close();
		}
	}
	
	public  CustomEventDao getEventDao() throws ServiceException {
		logger.info("run method getEventDao");
		if (eventDao == null) {
			logger.error("error. need eventDao in EventService");
			throw new ServiceException("need eventDao in EventService.");
		}
		return eventDao;
	}
	
	public void setUserDao() {
		logger.info("setUserDao");
		this.userDao = new UserDao();
		this.userDao.setEntityManager(em);
	}

	public void setCriminalDao() {
		logger.info("setCriminalDao");
		this.criminalDao = new CriminalDao();
		this.criminalDao.setEntityManager(em);
	}

	public void setEventTypeDao() {
		logger.info("setEventTypeDao");
		this.eventTypeDao = new EventTypeDao();
		this.eventTypeDao.setEntityManager(em);
	}

	public void setEventDao(CustomEventDao eventDao) {
		logger.info("setEventDao");
		this.eventDao = eventDao;
		this.eventDao.setEntityManager(em);
	}

}
