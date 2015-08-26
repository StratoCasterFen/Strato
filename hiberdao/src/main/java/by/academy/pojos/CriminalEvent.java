package by.academy.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import by.academy.mydao.Identified;

@Entity
@Table(name= "criminalevents")
public class CriminalEvent implements Serializable{
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id=null;
	
	@Column(name= "EventName")
	private String   eventName;
	
	@Column(name= "EventDescription")
	private String   eventDescription;
	
	@Column(name= "EventDate")
	@Temporal(value=TemporalType.DATE)
	private Date     eventDate;
	
	@ManyToOne
	@JoinColumn(name= "CriminalId")
	private Criminal criminal;
	
	@ManyToOne
	@JoinColumn(name= "UserId")
	private User  user;
	
	
	public CriminalEvent() {
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
	public Criminal getCriminal() {
		return criminal;
	}
	public void setCriminalId(Criminal criminal) {
		this.criminal = criminal;
	}
	public User getUser() {
		return user;
	}
	public void setUserId(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "CriminalEvent [id=" + id + ", eventName=" + eventName + ", eventDescription="
				+ eventDescription + ", eventDate=" + eventDate + ", criminal=" + criminal + ", user=" + user+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criminal == null) ? 0 : criminal.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventDescription == null) ? 0 : eventDescription.hashCode());
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
		CriminalEvent other = (CriminalEvent) obj;
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
		if (eventDescription == null) {
			if (other.eventDescription != null)
				return false;
		} else if (!eventDescription.equals(other.eventDescription))
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
	
}
