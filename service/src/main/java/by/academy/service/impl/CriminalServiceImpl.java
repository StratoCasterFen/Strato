package by.academy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.academy.domain.Criminal;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.interf.CriminalService;

public class CriminalServiceImpl implements CriminalService {
	static Logger logger = Logger
			.getLogger(CriminalServiceImpl.class.getName());
	private GenericDao<Criminal, Integer> criminalDao;
	private MySqlCriminalDao mCriminal = (MySqlCriminalDao) criminalDao;

	@Override
	public List<Criminal> getCriminals() throws DaoException {
		logger.info("run method getCriminals");
		return mCriminal.getAll();
	}

	@Override
	public Criminal getCriminalById(Integer criminalId) throws DaoException,
			ServiceException {
		logger.info("+getCriminalsById");
		Criminal criminal = null;
		try {
			criminal = getCriminalDao().getByPK(criminalId);
		} catch (DaoException e) {
			logger.error("can not get criminal by Id");
			throw new ServiceException("can not get criminal by Id. ", e);
		}
		logger.debug("-getCriminalsById. Return criminal: " + criminal);
		return criminal;
	}

	private GenericDao<Criminal, Integer> getCriminalDao()
			throws ServiceException {
		logger.info("run method getCriminalDao");
		if (criminalDao == null) {
			logger.error("error. need criminalDao in CriminalService");
			throw new ServiceException("need criminalDao in CriminalService.");
		}
		return criminalDao;
	}

	@Override
	public void addCriminal(Criminal criminal) throws DaoException,
			ServiceException {
		logger.info("+addCriminal.");
		try {
			criminalDao.persist(criminal);
		} catch (DaoException e) {
			logger.error("could not add event");
			throw new ServiceException("could not add event.");
		}
		logger.info("-addCriminal successfully.");
	}

	@Override
	public void updateCriminal(Criminal criminal) throws DaoException,
			ServiceException {
		logger.info("+updateCriminal " + criminal.getId());
		try {
			getCriminalDao().update(criminal);
		} catch (DaoException e) {
			logger.error("Cannot update Criminal with id: " + criminal.getId());
			throw new ServiceException("Cannot update Criminal with id: "
					+ criminal.getId(), e);
		}
		logger.info("-updateCriminal successfully.");
	}

	@Override
	public void deleteById(int criminalId) throws DaoException,
			ServiceException {
		logger.info("+deleteById");

		try {
			Criminal criminal = getCriminalById(criminalId);
			getCriminalDao().delete(criminal);
		} catch (DaoException e) {
			logger.error("can not delete criminal " + criminalId + ". ");
			throw new ServiceException("can not delete criminal. " + e);
		}
		logger.info("-deleteById.");
	}

	public void setCriminalDao(GenericDao<Criminal, Integer> criminalDao) {
		logger.info("run method setEventDao");
		this.criminalDao = criminalDao;
	}

}
