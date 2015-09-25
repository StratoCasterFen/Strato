package by.academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.CriminalRepo;
import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;
import by.academy.service.inter.CriminalService;

public class CriminalServiceImpl implements CriminalService {
	
	@Autowired
	private CriminalRepo criminalRepo;

	@Override
	public List<Criminal> getCriminals() {
		criminalRepo.findAll();
		return null;
	}

	@Override
	@Transactional
	public void addCriminal(Criminal criminal) {
		Criminal savedCriminal = criminalRepo.saveAndFlush(criminal);
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
