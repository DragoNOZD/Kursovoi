package ru.mmo.database.account.privilege;

import ru.mmo.database.account.role.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Privilege {

	@Id
	private String name;

	@ManyToMany(mappedBy = "privileges")
	private Set<Role> roles;

	public Privilege(String name) {
		this.name = name;
	}

	public Privilege() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
