package by.academy.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.DaoException;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.EventService;

public class EventServiceImpl implements EventService {
	
	static Logger logger= Logger.getLogger(EventServiceImpl.class.getName());
	
	@Override
	public int add(CriminalEvent event) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByID(int eventId) throws DaoException {
		// TODO Auto-generated method stub
		
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

}
