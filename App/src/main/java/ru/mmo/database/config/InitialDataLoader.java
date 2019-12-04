package ru.mmo.database.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.mmo.database.account.Account;
import ru.mmo.database.account.AccountService;
import ru.mmo.database.account.privilege.Privilege;
import ru.mmo.database.account.privilege.PrivilegeRepository;
import ru.mmo.database.account.role.Role;
import ru.mmo.database.account.role.RoleRepository;

import java.util.*;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	private final AccountService accountService;

	private final RoleRepository roleRepository;

	private final PrivilegeRepository privilegeRepository;

	private final PasswordEncoder passwordEncoder;

	public InitialDataLoader(AccountService accountService, RoleRepository roleRepository, PrivilegeRepository privilegeRepository, PasswordEncoder passwordEncoder) {
		this.accountService = accountService;
		this.roleRepository = roleRepository;
		this.privilegeRepository = privilegeRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (alreadySetup) {
			return;
		}
		Privilege readPrivilege = createPrivilegeIfNotFound("Read");
		Privilege writePrivilege = createPrivilegeIfNotFound("Write");

		Set<Privilege> adminPrivileges = new HashSet<>();
		adminPrivileges.add(readPrivilege);
		adminPrivileges.add(writePrivilege);
		Role adminRole = createRoleIfNotFound("Admin", adminPrivileges);
		Set<Privilege> userPrivileges = new HashSet<>();
		userPrivileges.add(readPrivilege);
		Role userRole = createRoleIfNotFound("User", userPrivileges);

		Account admin = new Account("Admin", passwordEncoder.encode("test"));
		admin.setEmail("test@test.com");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminRoles.add(userRole);
		admin.setRoles(adminRoles);
		accountService.addUser(admin);

		alreadySetup = true;
	}

	@Transactional
	public Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = privilegeRepository.findOne(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.saveAndFlush(privilege);
		}
		return privilege;
	}

	@Transactional
	public Role createRoleIfNotFound(String name, Set<Privilege> privileges) {

		Role role = roleRepository.findOne(name);
		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			roleRepository.saveAndFlush(role);
		}
		return role;
	}
}
