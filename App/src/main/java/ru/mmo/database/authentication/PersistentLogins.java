package ru.mmo.database.authentication;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logins_persistent")
public class PersistentLogins {

	@Id
	private String series;

	@JoinColumn(nullable = false, table = "account", referencedColumnName = "login")
	private String username;

	@Column(nullable = false)
	private String token;

	@Column(name = "last_used", nullable = false)
	private Date lastUsed;

	public PersistentLogins() {
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
}
