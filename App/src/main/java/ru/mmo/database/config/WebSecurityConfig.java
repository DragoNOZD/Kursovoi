package ru.mmo.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
@ComponentScan({"ru.mmo.database"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	private PersistentTokenRepository persistentTokenRepository;

	@Autowired
	public WebSecurityConfig(UserDetailsService userDetailsService, PersistentTokenRepository persistentTokenRepository) {
		this.userDetailsService = userDetailsService;
		this.persistentTokenRepository = persistentTokenRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().hasAnyRole()
				.and()
				.authorizeRequests().antMatchers("/users**").permitAll()
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginCheck").permitAll()
				.and()
				.logout().logoutSuccessUrl("/login").permitAll()
				.and()
				.rememberMe().rememberMeParameter("remember-me")
				.tokenRepository(persistentTokenRepository).userDetailsService(userDetailsService)
				.and()
				.csrf().disable();
	}
}
