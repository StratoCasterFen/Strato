package by.academy.service.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.CriminalRepo;
import by.academy.pojos.Criminal;

@Service
public class CriminalServiceImpl implements CriminalService {
	
	@Autowired
	private CriminalRepo criminalRepo;

	@Override
	public List<Criminal> getCriminals() {
		return criminalRepo.findAll();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Criminal addCriminal(Criminal criminal) {
		Criminal savedCriminal = criminalRepo.saveAndFlush(criminal);
		return savedCriminal;	
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteByID(Integer criminalId) {
		criminalRepo.delete(criminalId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateCriminal(Criminal criminal) {
		criminalRepo.saveAndFlush(criminal);
	}

	@Override
	public Criminal getCriminalById(Integer criminalId) {
		return criminalRepo.findOne(criminalId);
	}

	@Override
	public Criminal getCriminalByName(String cName) {
		return criminalRepo.getCriminalByName(cName);
	}

	@Override
	public Criminal getCriminalBySurName(String cSurname) {
		return criminalRepo.getCriminalBySurName(cSurname);
	}

}
