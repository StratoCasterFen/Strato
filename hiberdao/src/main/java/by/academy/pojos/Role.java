package by.academy.pojos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "roles")
@Access(AccessType.FIELD)
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "RoleName")
	private String  roleName;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles",
	cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<User> users;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [Id=" + id + ", roleName=" + roleName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
}
