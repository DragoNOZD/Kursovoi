package ru.mmo.database.account.details;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mmo.database.account.Account;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {

	private SessionFactory sessionFactory;

	@Autowired
	public AccountDetailsServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Account account = sessionFactory.getCurrentSession().get(Account.class, login);

		if (account == null){ throw new UsernameNotFoundException("User not found."); }

		User.UserBuilder userBuilder = User.withUsername(login);
		userBuilder.password(account.getPassword());

		return userBuilder.build();
	}
}
