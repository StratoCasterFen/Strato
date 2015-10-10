package by.academy.service.srv;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.CriminalRepo;
import by.academy.dto.CriminalDto;
import by.academy.dto.EventDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;

@Service("criminalService")
@Transactional
public class CriminalServiceImpl implements CriminalService {
	static Logger logger = Logger.getLogger(CriminalServiceImpl.class.getName());

	
	@Autowired
	private CriminalRepo criminalRepo;
	
	public static class ConvertDto {

		public static List fromCriminalList(List<Criminal> criminals) {
			logger.info("***Convert CriminalList to CriminalDtoList***");
			List<CriminalDto> criminalsDto = new ArrayList<>();
			for (Criminal criminal : criminals) {
				criminalsDto.add(fromCriminal(criminal));
			}
			return criminalsDto;
		}

		private static CriminalDto fromCriminal(Criminal criminal) {
			if (criminal == null) {
				logger.debug("criminal is null");
				return null;
			}
			CriminalDto criminalDto = new CriminalDto(
					criminal.getId(),
					criminal.getCriminalName(),
					criminal.getCriminalSurname(),
					criminal.getBirthday());
					
			return criminalDto;
		}
		private static Criminal toCriminal(CriminalDto criminalDto) {

			if (criminalDto == null) {
				logger.debug("criminalDto is null");
				return null;
			}
			Criminal criminal = new Criminal();
			criminal.setId(criminalDto.getId());
			criminal.setCriminalName(criminalDto.getCriminalName());
			criminal.setCriminalSurname(criminalDto.getCriminalSurname());
			criminal.setBirthday(criminalDto.getBirthday());
					
			return criminal;
		}
	}

	@Override
	public List<CriminalDto> getCriminals() {
		List<Criminal> criminals=criminalRepo.findAll();
		List<CriminalDto> criminalsDto=ConvertDto.fromCriminalList(criminals);
		return criminalsDto;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Criminal addCriminal(CriminalDto criminalDto) {
		Criminal criminal = ConvertDto.toCriminal(criminalDto);
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
