package by.academy.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import by.academy.dao.CustomCriminalDao;
import by.academy.dao.DaoException;
import by.academy.pojos.Criminal;
import by.academy.service.exeption.ServiceException;
import by.academy.service.interf.CriminalService;
import by.academy.service.utils.ConnectionManager;

public class CriminalServiceImpl implements CriminalService {
	static Logger logger = Logger.getLogger(CriminalServiceImpl.class.getName());
	
	private EntityManager em;
	private CustomCriminalDao criminalDao;
	
	public CriminalServiceImpl() throws ServiceException {
		try {
			this.em=ConnectionManager.getEntityManager();
		} catch (DaoException e) {
			logger.error("dont get EntityManager");
			throw new ServiceException("dont get EntityManager",e);
		}
	}

	@Override
	public List<Criminal> getCriminals() throws ServiceException {
		logger.info("getCriminals");
		try {
			logger.info("run method getCriminals");
			return criminalDao.getAll();
		} catch (DaoException e) {
			logger.error("need criminalDao in CriminalService.");
			throw new ServiceException("need criminalDao in CriminalService.");
		}
	}

	@Override
	public void addCriminal(Criminal criminal) throws ServiceException,
			ServiceException {
		logger.info("addCriminal");
		

	}

	@Override
	public void updateCriminal(Criminal criminal) throws ServiceException,
			ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int criminalId) throws ServiceException,
			ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Criminal getCriminalById(Integer criminalId) throws ServiceException,
			ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCriminalDao(CustomCriminalDao criminalDao) {
		logger.info("setCriminalDao");
		this.criminalDao = criminalDao;
		this.criminalDao.setEntityManager(em);
	}

}
