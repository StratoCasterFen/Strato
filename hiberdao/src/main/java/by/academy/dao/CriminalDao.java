package by.academy.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import by.academy.dao.exception.DaoException;
import by.academy.hbutil.ReadProperty;
import by.academy.pojos.Criminal;


public class CriminalDao extends AbstractHDao<Criminal> implements CustomCriminalDao{
	static Logger logger= Logger.getLogger(CriminalDao.class.getName());
	
	public CriminalDao(){
	}

	@Override
	public Criminal getCriminalByName(String cName) throws DaoException {
		logger.info("+getCriminalByName");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("CriminalByName");
		try {
			Criminal res = (Criminal)super.entityManager.createQuery(QUERY).setParameter("name", cName).getSingleResult();
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
	public Criminal getCriminalBySurName(String cSurname) throws DaoException {
		logger.info("+getCriminalBySurName");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("CriminalBySurName");
		try {
			List<Criminal> res = super.entityManager.createQuery(QUERY).setParameter("name", cSurname).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return res.get(0);
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}
}
