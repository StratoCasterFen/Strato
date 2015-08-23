package by.academy.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import org.hibernate.annotations.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.hibernate.annotations.Table;

//import by.academy.mydao.Identified;

@Entity
@Table(name= "CRIMINAL")
public class Criminal implements Serializable {
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id=null;
	
	@Column(name= "Name")
	private String  criminalName;
	
	@Column(name= "SurName")
	private String  criminalSurname;
	
	@Column(name= "birthday")
	@Temporal(value=TemporalType.DATE)
	private Date    birthday;
	
	public Criminal() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCriminalName() {
		return criminalName;
	}
	
	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}
	public String getCriminalSurname() {
		return criminalSurname;
	}
	public void setCriminalSurname(String criminalSurname) {
		this.criminalSurname = criminalSurname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Criminal [id=" + id + ", criminalName=" + criminalName + ", criminalSurname="
				+ criminalSurname + ", birthday=" + birthday + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((criminalName == null) ? 0 : criminalName.hashCode());
		result = prime * result + ((criminalSurname == null) ? 0 : criminalSurname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Criminal))
			return false;
		Criminal other = (Criminal) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (criminalName == null) {
			if (other.criminalName != null)
				return false;
		} else if (!criminalName.equals(other.criminalName))
			return false;
		if (criminalSurname == null) {
			if (other.criminalSurname != null)
				return false;
		} else if (!criminalSurname.equals(other.criminalSurname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
