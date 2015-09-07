package by.academy.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import by.academy.dao.CustomCriminalDao;
import by.academy.dao.DaoException;
import by.academy.pojos.Criminal;
import by.academy.service.ServiceException;
import by.academy.service.interf.ICriminalService;
import by.academy.service.utils.ConnectionManager;

public class CriminalService implements ICriminalService {
	static Logger logger = Logger.getLogger(CriminalService.class.getName());
	private EntityManager em;
	
	private CustomCriminalDao criminalDao;
	
	public CriminalService() throws DaoException{
		this.em=ConnectionManager.getEntityManager();
	}

	@Override
	public List<Criminal> getCriminals() throws DaoException, ServiceException {
		logger.info("getCriminals");
		try {
			logger.info("run method getCriminals");
			return criminalDao.getAll();
		} catch (DaoException e) {
			logger.error("need criminalDao in CriminalService.");
			throw new ServiceException("need criminalDao in CriminalService.");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public void addCriminal(Criminal criminal) throws DaoException,
			ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCriminal(Criminal criminal) throws DaoException,
			ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int criminalId) throws DaoException,
			ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Criminal getCriminalById(Integer criminalId) throws DaoException,
			ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCriminalDao(CustomCriminalDao criminalDao) {
		this.criminalDao = criminalDao;
		this.criminalDao.setEntityManager(em);
	}

}
