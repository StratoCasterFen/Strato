package by.academy.pojos;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name= "users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "UserName")
	private String  userName;
	
	@Column(name= "Password")
	private String  password;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_role",
	        joinColumns = @JoinColumn(name="Userid", referencedColumnName="id"),
	        inverseJoinColumns = @JoinColumn(name="Roleid", referencedColumnName="id"))
    private Set<Role> roles;
	
	public User() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles; 
	}

	@Override
	public String toString() {
		return "User [UserId=" + id + ", UserName=" + userName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


		
}
