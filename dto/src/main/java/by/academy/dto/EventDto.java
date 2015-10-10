package by.academy.dto;

import java.io.Serializable;
import java.util.Date;

public class EventDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer  id;
	private String eventName;
	private String description;
	private Date eventDate;
	private Integer criminalId;
	private Integer userId;
	private Integer eventTypeId;
	
	public EventDto(Integer  id, String eventName, String description, java.util.Date date, Integer criminalId, Integer userId,
			Integer eventTypeId) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.description = description;
		this.eventDate = date;
		this.criminalId = criminalId;
		this.userId = userId;
		this.eventTypeId = eventTypeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(Integer criminalId) {
		this.criminalId = criminalId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criminalId == null) ? 0 : criminalId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventTypeId == null) ? 0 : eventTypeId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (criminalId == null) {
			if (other.criminalId != null)
				return false;
		} else if (!criminalId.equals(other.criminalId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (eventTypeId == null) {
			if (other.eventTypeId != null)
				return false;
		} else if (!eventTypeId.equals(other.eventTypeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventDto [id=" + id + ", eventName=" + eventName + ", description=" + description + ", eventDate="
				+ eventDate + ", criminalId=" + criminalId + ", userId=" + userId + ", eventTypeId=" + eventTypeId
				+ "]";
	}
	

}
