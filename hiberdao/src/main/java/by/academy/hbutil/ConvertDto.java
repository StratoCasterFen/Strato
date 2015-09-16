package by.academy.hbutil;

import org.apache.log4j.Logger;


import by.academy.dto.*;
import by.academy.pojos.*;

public class ConvertDto {
	static Logger logger= Logger.getLogger(ConvertDto.class.getName());
	
	public static UserDto fromUser(User user) {
		logger.info("Convert User to UserDto");
		if (user == null) {
			logger.debug("User is null");
			return null;
		}
		return new UserDto(user.getId(), user.getUserName(), user.getPassword());
	}
	
	public static RoleDto fromRole(Role role) {
		logger.info("Convert Role to RoleDto");
		if (role == null) {
			logger.debug("Role is null");
			return null;
		}
		return new RoleDto(role.getId(), role.getRoleName());
	}
	
	public static CriminalDto fromCriminal(Criminal criminal) {
		logger.info("Convert Criminal to CriminalDto");
		if (criminal == null) {
			logger.debug("Criminal is null");
			return null;
		}
		return new CriminalDto(criminal.getId(), criminal.getCriminalName(), criminal.getCriminalSurname(),
				criminal.getBirthday());
	}
	
	public static EventTypeDto fromEventType(EventType eventType) {
		logger.info("Convert EventType to EventTypeDto");
		if (eventType == null) {
			logger.debug("EventType is null");
			return null;
		}
		return new EventTypeDto(eventType.getId(), eventType.getEventTypeName());
	}
	
	public static EventDto fromCriminalEvent(CriminalEvent criminalEvent) {
		logger.info("Convert EventType to EventTypeDto");
		if (criminalEvent == null) {
			logger.debug("EventType is null");
			return null;
		}
		return new EventDto(criminalEvent.getId(), criminalEvent.getEventName(), 
				criminalEvent.getEventDescription(),criminalEvent.getEventDate(), 
				fromCriminal(criminalEvent.getCriminal()), 
				fromUser(criminalEvent.getUser()), 
				fromEventType(criminalEvent.getEventType()));
	}
	
	/* Another side */
	
	public static User toUser(UserDto userDto) {
		logger.info("Convert UserDto to User");
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());		
		return user;
	}
	
	public static Role toRole(RoleDto roleDto) {
		logger.info("Convert RoleDto to Role");
		if (roleDto == null) {
			return null;
		}
		Role role = new Role();
		role.setId(roleDto.getId());
		role.setRoleName(roleDto.getRoleName());
	
		return role;
	}
	
	public static Criminal toCriminal(CriminalDto criminalDto) {
		logger.info("Convert CriminalDto to Criminal");
		if (criminalDto == null) {
			return null;
		}
		Criminal criminal = new Criminal();
		criminal.setId(criminalDto.getId());
		criminal.setCriminalName(criminalDto.getCriminalName());
		criminal.setCriminalSurname(criminalDto.getCriminalSurname());
		criminal.setBirthday(criminalDto.getBirthday());
		
		return criminal;
	}
	
	public static EventType toEventType(EventTypeDto eventTypeDto) {
		logger.info("Convert EventTypeDto to EventType");
		if (eventTypeDto == null) {
			return null;
		}
		EventType eventType = new EventType();
		eventType.setId(eventTypeDto.getId());
		eventType.setEventTypeName(eventTypeDto.getEventTypeName());
		
		return eventType;
	}
	
	public static CriminalEvent toCriminalEvent(EventDto eventDto) {
		logger.info("Convert CriminalEventDto to CriminalEvent");
		if (eventDto == null) {
			return null;
		}
		CriminalEvent event = new CriminalEvent();
		event.setId(eventDto.getId());
		event.setEventName(eventDto.getEventName());
		event.setEventDescription(eventDto.getEventDescription());
		event.setEventDate(eventDto.getEventDate());
		event.setCriminal(toCriminal(eventDto.getCriminal()));
		event.setUser(toUser(eventDto.getUser()));
		event.setEventType(toEventType(eventDto.getEventType()));
		
		return event;
	}
}
