package ru.mmo.database.account.details;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mmo.database.account.Account;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountDetailsServiceImpl implements UserDetailsService {

	private SessionFactory sessionFactory;

	@Autowired
	public AccountDetailsServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Account account = sessionFactory.getCurrentSession().get(Account.class, login);

		if (account == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		User.UserBuilder userBuilder = User.withUsername(login);
		userBuilder.password(account.getPassword());
		String[] roles = account.getRolesNames().toArray(new String[0]);
		userBuilder.roles(roles);
		List<String> privileges = new ArrayList<>();
		account.getRoles()
				.forEach(role -> role.getPrivileges()
						.forEach(privilege -> privileges.add(privilege.getName()))
				);
		userBuilder.authorities(getGrantedAuthorities(privileges));

		return userBuilder.build();
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		privileges.forEach(s -> authorities.add(new SimpleGrantedAuthority(s)));
		return authorities;
	}
}
