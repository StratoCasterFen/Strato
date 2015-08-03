package by.academy.domain;

import java.util.Date;

import by.academy.mydao.Identified;

public class Criminal implements Identified<Integer>{
	private Integer id=null;
	private String  criminalName;
	private String  criminalSurname;
	private Date    birthday;
	
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
	
}
