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
		final String QNAME ="EventsByDate";
//		EntityTransaction tx = super.entityManager.getTransaction();
//		tx.begin();
//		String QUERY = ReadProperty.getQuery("EventsByDate");
//		try {
//			List<CriminalEvent> res = super.entityManager.createQuery(QUERY).setParameter("eventDate", date).getResultList();
//			tx.commit();
//			logger.info("commit successfuly");
//			return res;
//		} catch (IllegalArgumentException e) {
//			tx.rollback();
//			logger.error("rollback transaction. error in JPQL", e);
//			throw new DaoException("error in JPQL", e);
//		}
		
		return InitQuery("EventsByDate", "eventDate", date);
	}

	@Override
	public List<CriminalEvent> getEventsByCriminal(Criminal criminal) throws DaoException {
		logger.info("+getEventsByCriminal");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getQuery("EventsByCriminal");
		try {
			List<CriminalEvent> res = super.entityManager.createQuery(QUERY).setParameter("criminal", criminal).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return res;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	@Override
	public List<CriminalEvent> getEventsByType(EventType eventType) throws DaoException {
		logger.info("+getEventsByType");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getQuery("EventsByType");
		try {
			List<CriminalEvent> res = super.entityManager.createQuery(QUERY).setParameter("eventType", eventType).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return res;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	@Override
	public List<CriminalEvent> getEventsByUser(User user) throws DaoException {
		logger.info("+getEventsByUser");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getQuery("EventsByUser");
		try {
			List<CriminalEvent> res = super.entityManager.createQuery(QUERY).setParameter("user", user).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return res;
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	public List RunQuery(String qNam, String fKey, Object object) throws DaoException{
		logger.info("+RunQuery: "+ qNam);
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getQuery(qNam);
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
