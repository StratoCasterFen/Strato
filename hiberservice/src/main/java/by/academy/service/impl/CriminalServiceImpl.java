package by.academy.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.exception.DaoException;
import by.academy.dto.CriminalDto;
import by.academy.hbutil.ConvertDto;
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
			setCriminalDao(new CriminalDao());
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
		}finally{
			ConnectionManager.Close();
		}	
	}

	@Override
	public void addCriminal(CriminalDto criminalDto) throws ServiceException {
		logger.info("addCriminal");
		EntityTransaction tx = em.getTransaction();
		Criminal criminal=ConvertDto.toCriminal(criminalDto); 
		try {
			tx.begin();
			criminalDao.persist(criminal);
			tx.commit();
		} catch (DaoException e) {
			logger.error("could not add criminal");
			tx.rollback();
			throw new ServiceException("could not add criminal");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public void updateCriminal(CriminalDto criminalDto) throws ServiceException{
		logger.info("deleteById");
		
		EntityTransaction tx = em.getTransaction();Criminal criminal;
		try {
			criminal = criminalDao.getByPK(criminalDto.getId());
			criminal.setCriminalName(criminalDto.getCriminalName());
			criminal.setCriminalSurname(criminalDto.getCriminalSurname());
			criminal.setBirthday(criminalDto.getBirthday());
			tx.begin(); 
			criminal=criminalDao.update(criminal);
			tx.commit(); 
		} catch (DaoException e) {
			logger.error("could not update criminal");
			tx.rollback();
			throw new ServiceException("could not update criminal");
		}finally{
			ConnectionManager.Close();
		}
	}

	@Override
	public void deleteById(Integer criminalId) throws ServiceException {
		logger.info("deleteById");
		EntityTransaction tx = em.getTransaction();
		try {
			Criminal criminal=criminalDao.getByPK(criminalId);
			tx.begin();
			criminalDao.delete(criminal);
			tx.commit();
		} catch (DaoException e) {
			logger.error("could not delete criminal");
			tx.rollback();
			throw new ServiceException("could not delete criminal");
		}finally{
			ConnectionManager.Close();
		}	
	}

	@Override
	public Criminal getCriminalById(Integer criminalId) throws ServiceException
			 {
		try {
			Criminal criminal=criminalDao.getByPK(criminalId);
			return criminal;
		} catch (DaoException e) {
			logger.error("could not grt criminal");
			throw new ServiceException("could not get criminal");
		}
	}

	@Override
	public void setCriminalDao(CustomCriminalDao criminalDao) {
		logger.info("setCriminalDao");
		this.criminalDao = criminalDao;
		this.criminalDao.setEntityManager(em);
	}

}
