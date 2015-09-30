package by.academy.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.CriminalEventRepo;
import by.academy.dao.interf.CriminalEventService;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;


@Service
public class CriminalEventServiceImpl implements CriminalEventService {

	@Autowired
	private CriminalEventRepo criminalEventRepo;
	
	@Override
	public List<CriminalEvent> getCriminalEvents() {
		return criminalEventRepo.findAll();
	}

	@Override
	public CriminalEvent getCriminalEventById(Integer eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriminalEvent addCriminal(CriminalEvent criminalEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(Integer eventId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCriminal(CriminalEvent criminalEvent) {
		// TODO Auto-generated method stub
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
