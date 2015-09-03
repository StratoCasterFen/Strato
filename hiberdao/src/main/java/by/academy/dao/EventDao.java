package by.academy.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;

import by.academy.hbutil.ReadProperty;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;

public class EventDao extends AbstractHDao<CriminalEvent> implements CustomEventDao{

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) throws DaoException {
		logger.info("+getEventsByDate");
		final String QNAME = "EventsByDate";
		final String PNAME = "eventDate";
		
		return RunQuery(QNAME, PNAME, date);
	}

	@Override
	public List<CriminalEvent> getEventsByCriminal(Criminal criminal) throws DaoException {
		logger.info("+getEventsByCriminal");
		final String QNAME = "EventsByCriminal";
		final String PNAME = "criminal";
		
		return RunQuery(QNAME, PNAME, criminal);
	}

	@Override
	public List<CriminalEvent> getEventsByType(EventType eventType) throws DaoException {
		logger.info("+getEventsByType");
		final String QNAME = "EventsByType";
		final String PNAME = "eventType";
		
		return RunQuery(QNAME, PNAME, eventType);
	}

	@Override
	public List<CriminalEvent> getEventsByUser(User user) throws DaoException {
		logger.info("+getEventsByUser");
		final String QNAME = "EventsByUser";
		final String PNAME = "user";
		
		return RunQuery(QNAME, PNAME, user);
	}

	public List RunQuery(String qNam, String fKey, Object object) throws DaoException{
		logger.info("+RunQuery: "+ qNam);
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getValue(qNam);
		try {
			List res = super.entityManager.createQuery(QUERY).setParameter(fKey, object).getResultList();
			tx.commit();
			logger.info("commit successfuly "+ res);
			return res;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
		
	}
}
