package maxxx580.urlShortener.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private int id;
	@Size(min=5, message="User name should be at least 5 characters")
	private String userName;
	private String token;
	@Past
	private Date creationDate;
	
	public User(int id, String userName, String token, Date creationDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.token = token;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getToken() {
		return token;
	}
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", token=" + token + ", creationDate=" + creationDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id != other.id)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
}
