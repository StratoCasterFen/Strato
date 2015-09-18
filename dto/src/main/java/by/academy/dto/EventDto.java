package by.academy.dto;

import java.io.Serializable;
import java.util.Date;

public class EventDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer  id;
	private String eventName;
	private String description;
	private Date eventDate;
	private CriminalDto criminal;
	private UserDto user;
	private EventTypeDto eventType;
	
	/**
	  Integer id, String eventName, String description, Date eventDate, CriminalDto criminal,
			UserDto user, EventTypeDto eventType
	 **/
	public EventDto(Integer id, String eventName, String description, Date eventDate, CriminalDto criminal,
			UserDto user, EventTypeDto eventType) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.description = description;
		this.eventDate = eventDate;
		this.criminal = criminal;
		this.user = user;
		this.setEventType(eventType);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return description;
	}
	public void setEventDescription(String description) {
		this.description = description;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public CriminalDto getCriminal() {
		return criminal;
	}
	public void setCriminal(CriminalDto criminal) {
		this.criminal = criminal;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "CriminalEvent [id=" + id + ", eventName=" + eventName + ", description="
				+ description + ", eventDate=" + eventDate + ", criminal=" + criminal + ", user=" + user+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criminal == null) ? 0 : criminal.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDto other = (EventDto) obj;
		if (criminal == null) {
			if (other.criminal != null)
				return false;
		} else if (!criminal.equals(other.criminal))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public EventTypeDto getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeDto eventType) {
		this.eventType = eventType;
	}
	
}
