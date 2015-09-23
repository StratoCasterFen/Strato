package by.academy.hbutil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				
		return new UserDto(user.getId(), user.getUserName());
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
	CriminalDto crimDto= new  CriminalDto(criminal.getId(), criminal.getCriminalName(), criminal.getCriminalSurname(),
			criminal.getBirthday());
	return crimDto;
	}
	
	public static List<CriminalDto> fromCriminals(List<Criminal> criminals) {
		logger.info("Convert Criminal list to CriminalDto list");
		if (criminals.isEmpty()) {
			logger.debug("Criminal list is empty");
			return null;
		}
		List<CriminalDto> CrimsDto=new ArrayList<CriminalDto>();
		for (Criminal criminal : criminals) {
			CrimsDto.add(fromCriminal(criminal));
		}
		logger.info("CriminalDTO list is: ");
		return CrimsDto;
	}
	
	public static EventTypeDto fromEventType(EventType eventType) {
		logger.info("Convert EventType to EventTypeDto");
		if (eventType == null) {
			logger.debug("EventType is null");
			return null;
		}
		return new EventTypeDto(eventType.getId(), eventType.getEventTypeName());
	}
	
//	public static EventDto fromCriminalEvent(CriminalEvent criminalEvent) {
//		logger.info("Convert EventType to EventTypeDto");
//		if (criminalEvent == null) {
//			logger.debug("EventType is null");
//			return null;
//		}
//		return new EventDto(criminalEvent.getId(), criminalEvent.getEventName(), 
//				criminalEvent.getEventDescription(),criminalEvent.getEventDate(), 
//				fromCriminal(criminalEvent.getCriminal()), 
//				criminalEvent.getUserId()), 
//				fromEventType(criminalEvent.getEventType()));
//	}
	
	/* Another side */
	
	public static User toUser(UserRoleDto userRoleDto) {
		logger.info("Convert UserDto to User");
		if (userRoleDto == null) {
			return null;
		}
		User user = new User();
	//	user.setId(userRoleDto.getIdUser());
		user.setUserName(userRoleDto.getUserName());
		user.setPassword(userRoleDto.getPassword());

//		Set<Role> roles = new HashSet();
//
//		for (RoleDto roleDto : userRoleDto.getRolesDto()) {
//			roles.add(toRole(roleDto));
//		}

		//user.setRoles(roles);
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
	//	criminal.setId(criminalDto.getId());
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
	//	event.setId(eventDto.getId());
		event.setEventName(eventDto.getEventName());
		event.setEventDescription(eventDto.getDescription());
		event.setEventDate(eventDto.getEventDate());
	//	event.setCriminal(toCriminal(eventDto.getCriminal()));
	//	event.setUser(toUser(eventDto.getUser()));
	//	event.setEventType(toEventType(eventDto.getEventType()));
		
		return event;
	}
}
