package by.academy.domain;

import java.util.Date;

import by.academy.mydao.Identified;

public class CriminalEvent implements Identified<Integer>{
	private Integer  id=null;
	private String   eventName;
	private String   eventDescription;
	private Date     eventDate;
	private Integer  criminalId;
	private Integer  userId;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
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
	
	@Override
	public String toString() {
		return "CriminalEvent [id=" + id + ", eventName=" + eventName + ", eventDescription="
				+ eventDescription + ", eventDate=" + eventDate + ", criminal=" + criminalId + ", user=" + userId+"]";
	}
	
}
