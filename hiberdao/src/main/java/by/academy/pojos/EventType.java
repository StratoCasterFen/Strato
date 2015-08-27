package by.academy.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EventType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "TypeName")
	private String  EventtypeName;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "id", nullable = false)
	private CriminalEvent criminalEvent;
	 
	public CriminalEvent getEventT() {
	    return criminalEvent;
	}
	 
	public void setBook(CriminalEvent criminalEvent) {
	    this.criminalEvent = criminalEvent;
	}
	
	public EventType() {
	}
	
	public EventType(String eventtypeName) {
		EventtypeName = eventtypeName;
	}

	public String getEventtypeName() {
		return EventtypeName;
	}

	public void setEventtypeName(String eventtypeName) {
		EventtypeName = eventtypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((EventtypeName == null) ? 0 : EventtypeName.hashCode());
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
		EventType other = (EventType) obj;
		if (EventtypeName == null) {
			if (other.EventtypeName != null)
				return false;
		} else if (!EventtypeName.equals(other.EventtypeName))
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
		return "EventType [id=" + id + ", EventtypeName=" + EventtypeName + "]";
	}
	
}
