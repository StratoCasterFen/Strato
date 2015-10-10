package by.academy.service.srv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.dao.iRepo.CriminalEventRepo;
import by.academy.dao.iRepo.CriminalRepo;
import by.academy.dao.iRepo.EventTypeRepo;
import by.academy.dao.iRepo.UserRepo;
import by.academy.dto.EventDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;
import by.academy.service.srv.UserServiceImpl.ConvertDto;


@Service("criminalEventService")
public class CriminalEventServiceImpl implements CriminalEventService {
	static Logger logger= Logger.getLogger(CriminalEventServiceImpl.class.getName());
	
	@Autowired
	private CriminalEventRepo criminalEventRepo;
	
	@Autowired
	private EventTypeRepo eventTypeRepo;
	
	@Autowired
	private CriminalRepo criminalRepo;
	
	@Autowired
	private UserRepo userRepo;
	
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
			if (event == null) {
				logger.debug("event is null");
				return null;
			}
			EventDto eventDto = new EventDto(
								event.getId(),
								event.getEventName(),
								event.getEventDescription(),
								event.getEventDate(),
								event.getCriminal().getId(),
								event.getUser().getId(),
								event.getEventType().getId());
			return eventDto;
		}

	}
	
	
	public CriminalEvent toEvent(EventDto eventDto) {
		logger.info("Convert eventDto to CriminalEvent");
		if (eventDto == null) {
			return null;
		}
		CriminalEvent event = new CriminalEvent();
		event.setId(eventDto.getId());
		event.setEventDate(eventDto.getEventDate());
		event.setEventName(eventDto.getEventName());
		event.setEventDescription(eventDto.getDescription());
		event.setEventType(eventTypeRepo.findOne(eventDto.getEventTypeId()));
		event.setCriminal(criminalRepo.findOne(eventDto.getCriminalId()));
		event.setUser(userRepo.findOne(eventDto.getUserId()));
		return event;
	}
	
	@Override
	public List<EventDto> getCriminalEvents() {
		List<CriminalEvent> events = criminalEventRepo.findAll();
		List<EventDto> eventsDto=ConvertDto.fromEventList(events);
		return eventsDto;
	}

	@Override
	public EventDto getCriminalEventById(Integer eventId) {
		logger.info("********getCriminalEventById*********");
		CriminalEvent event=criminalEventRepo.findOne(eventId);
		return ConvertDto.fromEvent(event);
	}

	@Override
	public CriminalEvent addCriminalEvent(EventDto eventDto) {
		logger.info("********addCriminalEvent*********");
		CriminalEvent criminalEvent=toEvent(eventDto);
		CriminalEvent savedcriminalEvent = criminalEventRepo.saveAndFlush(criminalEvent);
		return savedcriminalEvent;	
	}

	@Override
	public void deleteByID(Integer eventId) {
		logger.info("********deleteByID*********");
		criminalEventRepo.delete(eventId);
	}

	@Override
	public void updateCriminalEvent(EventDto eventDto) {
		logger.info("********updateCriminalEvent*********");
		CriminalEvent criminalEvent=criminalEventRepo.findOne(eventDto.getId());
		criminalEvent.setEventDate(eventDto.getEventDate());
		criminalEvent.setEventName(eventDto.getEventName());
		criminalEvent.setEventDescription(eventDto.getDescription());
		criminalEvent.setEventType(eventTypeRepo.findOne(eventDto.getEventTypeId()));
		criminalEvent.setCriminal(criminalRepo.findOne(eventDto.getCriminalId()));
		criminalEvent.setUser(userRepo.findOne(eventDto.getUserId()));
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
