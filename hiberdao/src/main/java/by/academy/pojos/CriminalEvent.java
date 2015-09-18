package by.academy.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import by.academy.mydao.Identified;

@Entity
@Table(name = "CRIMINALEVENTS")
public class CriminalEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String eventName;

	@Column(name = "Description")
	private String description;

	@Column(name = "EventDate")
	@Temporal(value = TemporalType.DATE)
	private Date eventDate;

	@ManyToOne(targetEntity = Criminal.class, fetch = FetchType.EAGER)
	@JoinTable(name = "eventlinks", joinColumns = @JoinColumn(name = "EventId", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "CriminalId", referencedColumnName = "id") )
	private Criminal criminal;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "eventlinks", joinColumns = @JoinColumn(name = "EventId", nullable = false) , inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "id", nullable = false) )
	private User user;

	@ManyToOne
	@JoinTable(name = "eventlinks", joinColumns = @JoinColumn(name = "Eventid", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "EventTypeid", referencedColumnName = "id") )
	private EventType eventType;

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

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

	public Criminal getCriminal() {
		return criminal;
	}

	public void setCriminal(Criminal criminal) {
		this.criminal = criminal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CriminalEvent [id=" + id + ", eventName=" + eventName + ", description=" + description + ", eventDate="
				+ eventDate + ", criminal=" + criminal + ", user=" + user + "]";
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

}
