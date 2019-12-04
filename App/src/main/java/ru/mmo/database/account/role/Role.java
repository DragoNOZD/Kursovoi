package ru.mmo.database.account.role;

import ru.mmo.database.account.Account;
import ru.mmo.database.account.privilege.Privilege;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Role {

	@Id
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<Account> accounts;

	@ManyToMany
	@CollectionTable(name = "role_privileges")
	private Set<Privilege> privileges;

	public Role(String name) {
		this.name = name;
	}

	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public List<String> getPrivilegesNames(){
		List<String> names = new ArrayList<>();;
		privileges.forEach(privilege -> names.add(privilege.getName()));
		return names;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
}
