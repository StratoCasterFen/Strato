package by.academy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.academy.dao.DaoException;
import by.academy.pojos.Criminal;
import by.academy.service.ServiceException;
import by.academy.service.interf.ICriminalService;

public class CriminalService implements ICriminalService {
	static Logger logger = Logger.getLogger(CriminalService.class.getName());

	@Override
	public List<Criminal> getCriminals() throws DaoException {
		// TODO Auto-generated method stub
		return null;
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

}
