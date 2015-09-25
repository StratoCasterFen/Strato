package by.academy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.CriminalRepo;
import by.academy.dao.interf.CriminalService;
import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;


public class CriminalServiceImpl implements CriminalService {
	
	@Autowired
	private CriminalRepo criminalRepo;

	@Override
	public List<Criminal> getCriminals() {
		return criminalRepo.findAll();
	}

	@Override
	@Transactional
	public Criminal addCriminal(Criminal criminal) {
		Criminal savedCriminal = criminalRepo.saveAndFlush(criminal);
		return savedCriminal;	
	}

	@Override
	@Transactional
	public void deleteByID(Integer criminalId) {
		criminalRepo.delete(criminalId);
	}

	@Override
	@Transactional
	public void updateCriminal(Criminal criminal) {
		criminalRepo.saveAndFlush(criminal);
	}

	@Override
	public Criminal getCriminalById(Integer criminalId) {
		return criminalRepo.findOne(criminalId);
	}

}
