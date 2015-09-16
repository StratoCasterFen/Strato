package by.academy.service.dto;

import java.io.Serializable;

public class EventTypeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String  eventTypeName;

	public EventTypeDto() {
	}
	
	public EventTypeDto(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventTypeName == null) ? 0 : eventTypeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EventTypeDto other = (EventTypeDto) obj;
		if (eventTypeName == null) {
			if (other.eventTypeName != null)
				return false;
		} else if (!eventTypeName.equals(other.eventTypeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventType [id=" + id + ", EventTypeName=" + eventTypeName + "]";
	}
	
}
