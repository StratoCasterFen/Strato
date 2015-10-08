package by.academy.service.srv;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.CriminalEventRepo;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;


@Service
public class CriminalEventServiceImpl implements CriminalEventService {
	static Logger logger= Logger.getLogger(CriminalEventServiceImpl.class.getName());
	
	@Autowired
	private CriminalEventRepo criminalEventRepo;
	
	@Override
	public List<CriminalEvent> getCriminalEvents() {
		return criminalEventRepo.findAll();
	}

	@Override
	public CriminalEvent getCriminalEventById(Integer eventId) {
		logger.info("********getCriminalEventById*********");
		return criminalEventRepo.findOne(eventId);
	}

	@Override
	public CriminalEvent addCriminalEvent(CriminalEvent criminalEvent) {
		logger.info("********addCriminalEvent*********");
		CriminalEvent savedcriminalEvent = criminalEventRepo.saveAndFlush(criminalEvent);
		return savedcriminalEvent;	
	}

	@Override
	public void deleteByID(Integer eventId) {
		logger.info("********deleteByID*********");
		criminalEventRepo.delete(eventId);
	}

	@Override
	public void updateCriminalEvent(CriminalEvent criminalEvent) {
		logger.info("********updateCriminalEvent*********");
		 criminalEventRepo.saveAndFlush(criminalEvent);
	}

	@Override
	public List<CriminalEvent> getEventsByDate(Date date) {
		return criminalEventRepo.getEventsByDate(date);
	}

	@Override
	public List<CriminalEvent> getEventsByCriminal(Criminal criminal) {
		return criminalEventRepo.getEventsByCriminal(criminal);
	}

	@Override
	public List<CriminalEvent> getEventsByType(EventType eventType) {
		return criminalEventRepo.getEventsByType(eventType);
	}

	@Override
	public List<CriminalEvent> getEventsByUser(User user) {
		return criminalEventRepo.getEventsByUser(user);
	}

}
