package by.academy.service.srv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.CriminalEventRepo;
import by.academy.dto.EventDto;
import by.academy.dto.RoleDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.Role;
import by.academy.pojos.User;


@Service("criminalEventService")
public class CriminalEventServiceImpl implements CriminalEventService {
	static Logger logger= Logger.getLogger(CriminalEventServiceImpl.class.getName());
	
	@Autowired
	private CriminalEventRepo criminalEventRepo;
	
	public static class ConvertDto {

		public static List fromEventList(List<CriminalEvent> events) {
			logger.info("***Convert eventList to eventDtoList***");
			List<EventDto> eventsDto = new ArrayList<>();
			for (CriminalEvent event : events) {
				eventsDto.add(fromEvent(event));
			}
			return eventsDto;
		}

		private static EventDto fromEvent(CriminalEvent event) {
			logger.info("Convert Event to EventDto");
			if (event == null) {
				logger.debug("event is null");
				return null;
			}
			EventDto eventDto = new EventDto(
								event.getEventName(),
								event.getEventDescription(),
								event.getEventDate(),
								event.getCriminal().getId(),
								event.getUser().getId(),
								event.getEventType().getId());
			return eventDto;
		}
	}
	
	@Override
	public List<EventDto> getCriminalEvents() {
		List<CriminalEvent> events = criminalEventRepo.findAll();
		List<EventDto> eventsDto=ConvertDto.fromEventList(events);
		return eventsDto;
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
